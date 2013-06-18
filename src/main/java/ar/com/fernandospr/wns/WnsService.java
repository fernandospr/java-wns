package ar.com.fernandospr.wns;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import ar.com.fernandospr.wns.exceptions.WnsException;
import ar.com.fernandospr.wns.model.WnsAbstractNotification;
import ar.com.fernandospr.wns.model.WnsBadge;
import ar.com.fernandospr.wns.model.WnsOAuthToken;
import ar.com.fernandospr.wns.model.WnsTile;
import ar.com.fernandospr.wns.model.WnsToast;
import ar.com.fernandospr.wns.model.types.WnsNotificationType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class WnsService {
	private static final String SCOPE = "notify.windows.com";
	private static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
	private static final String AUTHENTICATION_URI = "https://login.live.com/accesstoken.srf";
	
	private String sid;
	private String clientSecret;
	private WnsOAuthToken token;
	
	/**
	 * @param sid
	 * @param clientSecret
	 * @throws WnsException when authentication fails
	 */
	public WnsService(String sid, String clientSecret) throws WnsException {
		this.sid = sid;
		this.clientSecret = clientSecret;
		this.token = getAccessToken();
	}
	
	private static Client createClient() {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		client.addFilter(new LoggingFilter(System.out));
		return client;
	}
	
	/**
	 * Based on http://msdn.microsoft.com/en-us/library/windows/apps/hh465407.aspx
	 * @throws WnsException when authentication fails
	 */
	protected WnsOAuthToken getAccessToken() throws WnsException {
		Client client = createClient();
		WebResource webResource = client.resource(AUTHENTICATION_URI);
		MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
		formData.add("grant_type", GRANT_TYPE_CLIENT_CREDENTIALS);
		formData.add("client_id", this.sid);
		formData.add("client_secret", this.clientSecret);
		formData.add("scope", SCOPE);
		ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
											 .accept(MediaType.APPLICATION_JSON_TYPE)
											 .post(ClientResponse.class, formData);
		if (response.getStatus() != 200) {
			throw new WnsException("Authentication failed. HTTP error code: " + response.getStatus());
		}
		
		return response.getEntity(WnsOAuthToken.class);
	}
	
	/**
	 * Pushes a tile to channelUri
	 * @param channelUri
	 * @param tile which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsTileBuilder}
	 * @throws WnsException please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	public void pushTile(String channelUri, WnsTile tile) throws WnsException {
		this.push(channelUri, WnsNotificationType.TILE, tile);
	}
	
	/**
	 * Pushes a toast to channelUri
	 * @param channelUri
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @throws WnsException please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	public void pushToast(String channelUri, WnsToast toast) throws WnsException {
		this.push(channelUri, WnsNotificationType.TOAST, toast);
	}
	
	/**
	 * Pushes a badge to channelUri
	 * @param channelUri
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @throws WnsException please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	public void pushBadge(String channelUri, WnsBadge badge) throws WnsException {
		this.push(channelUri, WnsNotificationType.BADGE, badge);
	}
		
	// TODO: add push methods with optional request parameters from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_request
	
	// TODO: return object from push methods, http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	
	// TODO: add description of response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	
	/**
	 * @param channelUri
	 * @param type should be any of {@link ar.com.fernandospr.wns.model.types.WnsNotificationType}
	 * @param notification
	 * @throws WnsException please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	protected void push(String channelUri, String type, WnsAbstractNotification notification) throws WnsException {
		Client client = createClient();
		WebResource webResource = client.resource(channelUri);
		ClientResponse response = webResource.type(MediaType.TEXT_XML)
											 .header("X-WNS-Type", type)
											 .header("Authorization", "Bearer " + this.token.access_token)
											 .post(ClientResponse.class, notification);
		if (response.getStatus() != 200) {
			if (response.getStatus() == 401) {
				// Access token may have expired
				this.token = getAccessToken();
				// Retry
				this.push(channelUri, type, notification);
				
				// TODO: implement retry policy 
			} else {
				throw new WnsException("Push failed. HTTP error code: " + response.getStatus());
			}
		}
	}
}
