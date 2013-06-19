package ar.com.fernandospr.wns;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import ar.com.fernandospr.wns.exceptions.WnsException;
import ar.com.fernandospr.wns.model.WnsAbstractNotification;
import ar.com.fernandospr.wns.model.WnsBadge;
import ar.com.fernandospr.wns.model.WnsNotificationRequestOptional;
import ar.com.fernandospr.wns.model.WnsNotificationResponse;
import ar.com.fernandospr.wns.model.WnsOAuthToken;
import ar.com.fernandospr.wns.model.WnsTile;
import ar.com.fernandospr.wns.model.WnsToast;
import ar.com.fernandospr.wns.model.types.WnsNotificationType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
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
	private Client client;
	
	private int retryPolicy = 5; // By default retry 5 times
	
	/**
	 * @param sid
	 * @param clientSecret
	 * @throws WnsException when authentication fails
	 */
	public WnsService(String sid, String clientSecret) throws WnsException {
		this(sid,clientSecret, false);
	}
	
	/**
	 * @param sid
	 * @param clientSecret
	 * @param logging true if System.out logging is needed
	 * @throws WnsException when authentication fails
	 */
	public WnsService(String sid, String clientSecret, boolean logging) throws WnsException {
		this.sid = sid;
		this.clientSecret = clientSecret;
		this.client = createClient(logging);
		this.token = getAccessToken();
	}
	
	private static Client createClient(boolean logging) {
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
		WebResource webResource = this.client.resource(AUTHENTICATION_URI);
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
	 * @return WnsNotificationResponse please see response headers from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 * @throws WnsException if it was unable to push the notification, please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	public WnsNotificationResponse pushTile(String channelUri, WnsTile tile) throws WnsException {
		return this.pushTile(channelUri, null, tile);
	}
	
	/**
	 * Pushes a tile to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param tile which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsTileBuilder}
	 * @return WnsNotificationResponse please see response headers from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 * @throws WnsException if it was unable to push the notification, please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	public WnsNotificationResponse pushTile(String channelUri, WnsNotificationRequestOptional optional, WnsTile tile) throws WnsException {
		return this.push(channelUri, WnsNotificationType.TILE, tile, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a toast to channelUri
	 * @param channelUri
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @return WnsNotificationResponse please see response headers from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 * @throws WnsException if it was unable to push the notification, please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	public WnsNotificationResponse pushToast(String channelUri, WnsToast toast) throws WnsException {
		return this.pushToast(channelUri, null, toast);
	}
	
	/**
	 * Pushes a toast to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param toast which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsToastBuilder}
	 * @return WnsNotificationResponse please see response headers from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 * @throws WnsException if it was unable to push the notification, please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	public WnsNotificationResponse pushToast(String channelUri, WnsNotificationRequestOptional optional, WnsToast toast) throws WnsException {
		return this.push(channelUri, WnsNotificationType.TOAST, toast, this.retryPolicy, optional);
	}
	
	/**
	 * Pushes a badge to channelUri
	 * @param channelUri
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return WnsNotificationResponse please see response headers from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 * @throws WnsException if it was unable to push the notification, please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	public WnsNotificationResponse pushBadge(String channelUri, WnsBadge badge) throws WnsException {
		return this.pushBadge(channelUri, null, badge);
	}

	/**
	 * Pushes a badge to channelUri using optional headers
	 * @param channelUri
	 * @param optional
	 * @param badge which should be built with {@link ar.com.fernandospr.wns.model.builders.WnsBadgeBuilder}
	 * @return WnsNotificationResponse please see response headers from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 * @throws WnsException if it was unable to push the notification, please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	public WnsNotificationResponse pushBadge(String channelUri, WnsNotificationRequestOptional optional, WnsBadge badge) throws WnsException {
		return this.push(channelUri, WnsNotificationType.BADGE, badge, this.retryPolicy, optional);
	}
	
	/**
	 * @param channelUri
	 * @param type should be any of {@link ar.com.fernandospr.wns.model.types.WnsNotificationType}
	 * @param notification
	 * @param retriesLeft to push the notification if the token expires
	 * @return WnsNotificationResponse please see response headers from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 * @throws WnsException if it was unable to push the notification, please see response codes from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
	 */
	protected WnsNotificationResponse push(String channelUri, String type, WnsAbstractNotification notification, int retriesLeft, WnsNotificationRequestOptional optional) throws WnsException {
		WebResource webResource = this.client.resource(channelUri);
		
		Builder webResourceBuilder = webResource.type(MediaType.TEXT_XML);
		addRequiredHeaders(webResourceBuilder, type, this.token.access_token);
		addOptionalHeaders(webResourceBuilder, optional);
		
		ClientResponse response = webResourceBuilder.post(ClientResponse.class, notification);
		
		WnsNotificationResponse notificationResponse = new WnsNotificationResponse(response.getStatus(), response.getHeaders());
		if (notificationResponse.code == 200) {
			return notificationResponse;
		}
		
		if (notificationResponse.code == 401 && retriesLeft > 0) {
			retriesLeft--;
			// Access token may have expired
			this.token = getAccessToken();
			// Retry
			return this.push(channelUri, type, notification, retriesLeft, optional);
		}
		
		// TODO: add description of response codes to WnsException from http://msdn.microsoft.com/en-us/library/windows/apps/hh465435.aspx#send_notification_response
		throw new WnsException("Push failed. HTTP error code: " + response.getStatus());
	}

	protected void addOptionalHeaders(Builder webResourceBuilder, WnsNotificationRequestOptional optional) {
		if (optional != null) {
			if (!emptyString(optional.cachePolicy)) {
				webResourceBuilder.header("X-WNS-Cache-Policy", optional.cachePolicy);
			}
			if (!emptyString(optional.requestForStatus)) {
				webResourceBuilder.header("X-WNS-RequestForStatus", optional.requestForStatus);
			}
			if (!emptyString(optional.tag)) {
				webResourceBuilder.header("X-WNS-Tag", optional.tag);
			}
			if (!emptyString(optional.ttl)) {
				webResourceBuilder.header("X-WNS-TTL", optional.ttl);
			}
		}
	}

	protected void addRequiredHeaders(Builder webResourceBuilder, String type, String accessToken) {
		 webResourceBuilder.header("X-WNS-Type", type)
		 				   .header("Authorization", "Bearer " + accessToken);
	}
	
	private boolean emptyString(String str) {
		return str == null || str.isEmpty();
	}
}
