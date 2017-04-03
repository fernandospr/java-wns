package ar.com.fernandospr.wns.client;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;


import ar.com.fernandospr.wns.WnsProxyProperties;
import ar.com.fernandospr.wns.exceptions.WnsException;
import ar.com.fernandospr.wns.model.*;
import ar.com.fernandospr.wns.model.types.WnsNotificationType;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.jaxrs.xml.JacksonJaxbXMLProvider;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.internal.util.collection.MultivaluedStringMap;


public class WnsClient {
	private static final String SCOPE = "notify.windows.com";
	private static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
	private static final String AUTHENTICATION_URI = "https://login.live.com/accesstoken.srf";
	
	private final String sid;
	private final String clientSecret;
	private WnsOAuthToken token;
	private final Client client;


	public WnsClient(String sid, String clientSecret, Client client) {
		this.sid = sid;
		this.clientSecret = clientSecret;
		this.client = client;
	}

	public WnsClient(String sid, String clientSecret, boolean logging) {
		this(sid, clientSecret, createClient(logging));
	}
	
	public WnsClient(String sid, String clientSecret, WnsProxyProperties proxyProps, boolean logging) {
		this(sid, clientSecret, createClient(logging, proxyProps));
	}

    private static Client createClient(boolean logging) {
        ClientConfig clientConfig = new ClientConfig(JacksonJaxbXMLProvider.class, JacksonJsonProvider.class);
        Client client = ClientBuilder.newClient(clientConfig);

        if (logging) {
            LoggingFilter loggingFilter = new LoggingFilter(
                    Logger.getLogger(WnsClient.class.getName()), true);

            client = client.register(loggingFilter);
        }
        return client;
    }

    private static Client createClient(boolean logging, WnsProxyProperties proxyProps) {
        ClientConfig clientConfig = new ClientConfig(JacksonJaxbXMLProvider.class, JacksonJsonProvider.class)
                .connectorProvider(new ApacheConnectorProvider());
        setProxyCredentials(clientConfig, proxyProps);

        Client client = ClientBuilder.newClient(clientConfig);
        if (logging) {
            LoggingFilter loggingFilter = new LoggingFilter(
                    Logger.getLogger(WnsClient.class.getName()), true);

            client = client.register(loggingFilter);
        }
        return client;
    }

    private static void setProxyCredentials(ClientConfig clientConfig, WnsProxyProperties proxyProps) {
        if (proxyProps != null) {
            String proxyUri = proxyProps.getUri();
            String proxyUser = proxyProps.getUser();
            String proxyPass = proxyProps.getPass();

            if (proxyUri != null) {
                clientConfig.property(ClientProperties.PROXY_URI, proxyUri);
                if ( (proxyUser != null) && !proxyUser.trim().isEmpty()) {
                    clientConfig.property(ClientProperties.PROXY_PASSWORD, proxyPass);
                    clientConfig.property(ClientProperties.PROXY_USERNAME, proxyUser);
                }
            }
        }
    }

    /**
     * Based on <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465407.aspx">http://msdn.microsoft.com/en-us/library/windows/apps/hh465407.aspx</a>
     *
     * @throws WnsException when authentication fails
     */
    public void refreshAccessToken() throws WnsException {
        WebTarget target = client.target(AUTHENTICATION_URI);

        MultivaluedStringMap formData = new MultivaluedStringMap();
        formData.add("grant_type", GRANT_TYPE_CLIENT_CREDENTIALS);
        formData.add("client_id", this.sid);
        formData.add("client_secret", this.clientSecret);
        formData.add("scope", SCOPE);
        Response response = target.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.form(formData));

        if (response.getStatus() != 200) {
            throw new WnsException("Authentication failed. HTTP error code: " + response.getStatus());
        }

        this.token = response.readEntity(WnsOAuthToken.class);
    }
	
	/**
	 * @param channelUri
	 * @param resourceBuilder
	 * @param notification
	 * @param retriesLeft to push the notification if the token expires
	 * @return WnsNotificationResponse please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public WnsNotificationResponse push(WnsResourceBuilder resourceBuilder, String channelUri, WnsAbstractNotification notification, int retriesLeft, WnsNotificationRequestOptional optional) throws WnsException {
        WebTarget target = client.target(channelUri);
        Invocation.Builder webResourceBuilder = resourceBuilder.build(target, notification, getToken().access_token, optional);
        String type = notification.getType().equals(WnsNotificationType.RAW) ? MediaType.APPLICATION_OCTET_STREAM : MediaType.TEXT_XML;

        Response response = webResourceBuilder.buildPost(Entity.entity(resourceBuilder.getEntityToSendWithNotification(notification), type)).invoke();

        WnsNotificationResponse notificationResponse = new WnsNotificationResponse(channelUri, response.getStatus(), response.getStringHeaders()    );
		if (notificationResponse.code == 200) {
			return notificationResponse;
		}
		
		if (notificationResponse.code == 401 && retriesLeft > 0) {
			retriesLeft--;
			// Access token may have expired
			refreshAccessToken();
			// Retry
			return this.push(resourceBuilder, channelUri, notification, retriesLeft, optional);
		}
		
		// Assuming push failed
		return notificationResponse;
	}
	
	private WnsOAuthToken getToken() throws WnsException {
		if (this.token == null) {
			refreshAccessToken();
		}
		return this.token;
	}

	/**
	 * @param channelUris
	 * @param resourceBuilder
	 * @param notification
	 * @param retriesLeft to push the notification if the token expires
	 * @return list of WnsNotificationResponse for each channelUri, please see response headers from <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response">http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response</a>
	 * @throws WnsException when authentication fails
	 */
	public List<WnsNotificationResponse> push(WnsResourceBuilder resourceBuilder, List<String> channelUris, WnsAbstractNotification notification, int retriesLeft, WnsNotificationRequestOptional optional) throws WnsException {
		List<WnsNotificationResponse> responses = new ArrayList<WnsNotificationResponse>();
		for (String channelUri : channelUris) {
			WnsNotificationResponse response = push(resourceBuilder, channelUri, notification, retriesLeft, optional);
			responses.add(response);
		}
		return responses;
	}
}
