package ar.com.fernandospr.wns.client;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import ar.com.fernandospr.wns.model.WnsAbstractNotification;
import ar.com.fernandospr.wns.model.WnsNotificationRequestOptional;
import ar.com.fernandospr.wns.model.types.WnsNotificationType;


public abstract class WnsResourceBuilder {
	
	public Invocation.Builder build(WebTarget target, WnsAbstractNotification notification, String token, WnsNotificationRequestOptional optional) {
		Invocation.Builder webResourceBuilder = target.request();

		addRequiredHeaders(webResourceBuilder, notification.getType(), token);
		addOptionalHeaders(webResourceBuilder, optional);
        
		return webResourceBuilder;
	}
	
	protected abstract Object getEntityToSendWithNotification(WnsAbstractNotification notification);
	
	protected void addOptionalHeaders(Invocation.Builder webResourceBuilder, WnsNotificationRequestOptional optional) {
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

	protected void addRequiredHeaders(Invocation.Builder webResourceBuilder, String type, String accessToken) {
		if (type.equalsIgnoreCase(WnsNotificationType.RAW)) {
			webResourceBuilder.accept(MediaType.APPLICATION_OCTET_STREAM);
		} else {
			webResourceBuilder.accept(MediaType.TEXT_XML);
		}
		webResourceBuilder.header("X-WNS-Type", type)
		 				  .header("Authorization", "Bearer " + accessToken);
	}
	
	private boolean emptyString(String str) {
		return str == null || str.isEmpty();
	}
}
