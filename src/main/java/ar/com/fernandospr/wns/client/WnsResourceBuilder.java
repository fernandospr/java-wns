package ar.com.fernandospr.wns.client;

import javax.ws.rs.core.MediaType;

import ar.com.fernandospr.wns.model.WnsAbstractNotification;
import ar.com.fernandospr.wns.model.WnsNotificationRequestOptional;
import ar.com.fernandospr.wns.model.types.WnsNotificationType;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public abstract class WnsResourceBuilder {
	
	public Builder build(WebResource webResource, WnsAbstractNotification notification, String token, WnsNotificationRequestOptional optional) {
		Builder webResourceBuilder = webResource.getRequestBuilder();
		addRequiredHeaders(webResourceBuilder, notification.getType(), token);
		addOptionalHeaders(webResourceBuilder, optional);
		webResourceBuilder.entity(this.getEntityToSendWithNotification(notification));
		return webResourceBuilder;
	}
	
	protected abstract Object getEntityToSendWithNotification(WnsAbstractNotification notification);
	
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
		if (type.equalsIgnoreCase(WnsNotificationType.RAW)) {
			webResourceBuilder.type(MediaType.APPLICATION_OCTET_STREAM);
		} else {
			webResourceBuilder.type(MediaType.TEXT_XML);
		}
		webResourceBuilder.header("X-WNS-Type", type)
		 				  .header("Authorization", "Bearer " + accessToken);
	}
	
	private boolean emptyString(String str) {
		return str == null || str.isEmpty();
	}
}
