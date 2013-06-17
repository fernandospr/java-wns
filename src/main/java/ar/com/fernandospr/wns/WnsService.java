package ar.com.fernandospr.wns;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import ar.com.fernandospr.wns.model.WnsBadge;
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
	private static final String AUTHENTICATION_URI = "https://login.live.com/accesstoken.srf";
	
	private String sid;
	private String clientSecret;
	private WnsOAuthToken token;
	
	public WnsService(String sid, String clientSecret) {
		this.sid = sid;
		this.clientSecret = clientSecret;
		this.token = getAccessToken(this.clientSecret, this.sid);
	}
	
	private static Client createClient() {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		client.addFilter(new LoggingFilter(System.out));
		return client;
	}
	
	protected WnsOAuthToken getAccessToken(String secret, String sid)
	{
		try {			
			Client client = createClient();
			WebResource webResource = client.resource(AUTHENTICATION_URI);
			MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
			formData.add("grant_type", "client_credentials");
			formData.add("client_id", sid);
			formData.add("client_secret", secret);
			formData.add("scope", "notify.windows.com");
			ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, formData);
			if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
			}
			
			return response.getEntity(WnsOAuthToken.class);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void pushTile(String pushUri, String tileText1, String tileText2) {
		String tileTemplate = "TileSquareBlock";
		String tileXmlString = "<?xml version='1.0' encoding='utf-8'?>" +
							   "<tile>" +
									"<visual>" +
										"<binding template=\""+ tileTemplate +"\">" +
											"<text id=\"1\">" + tileText1 + "</text>" +
											"<text id=\"2\">" + tileText2 + "</text>" +
										"</binding>" +
									"</visual>" +
							   "</tile>";
		
		this.push(pushUri, WnsNotificationType.TILE, tileXmlString);
	}
	
	public void pushToast(String pushUri, String toastText) {
		String toastTemplate = "ToastText01";
		String toastXmlString = "<?xml version='1.0' encoding='utf-8'?>" +
								"<toast>" +
									"<visual>" +
										"<binding template=\"" + toastTemplate + "\">" +
											"<text id=\"1\">" + toastText + "</text>" +
										"</binding>" +
									"</visual>" +
								"</toast>";
		
		this.push(pushUri, WnsNotificationType.TOAST, toastXmlString);
	}
	
	public void pushBadge(String pushUri, WnsBadge badge) {
		this.push(pushUri, WnsNotificationType.BADGE, badge);
	}
	
	protected void push(String pushUri, String type, String notificationData) {
		this.push(pushUri, type, notificationData);
	}
		
	protected void push(String pushUri, String type, Object notificationData) {
		try {			
			Client client = createClient();
			WebResource webResource = client.resource(pushUri);
			
			ClientResponse response = webResource.type(MediaType.TEXT_XML)
												 .header("X-WNS-Type", type)
												 .header("Authorization", "Bearer " + this.token.access_token)
												 .post(ClientResponse.class, notificationData);
			if (response.getStatus() != 200) {
				if (response.getStatus() == 401) {
					// Access token may have expired
					this.token = getAccessToken(this.clientSecret, this.sid);
					// Retry
					this.push(pushUri, type, notificationData);
					
					// TODO: implement retry policy 
				} else {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
