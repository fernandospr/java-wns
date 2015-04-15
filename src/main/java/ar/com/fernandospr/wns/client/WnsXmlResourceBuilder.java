package ar.com.fernandospr.wns.client;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

import ar.com.fernandospr.wns.model.WnsAbstractNotification;



public class WnsXmlResourceBuilder extends WnsResourceBuilder {
	
	@Override
	protected void addRequiredHeaders(Invocation.Builder webResourceBuilder, String type, String accessToken) {
		super.addRequiredHeaders(webResourceBuilder, type, accessToken);
		webResourceBuilder.accept(MediaType.TEXT_XML);
	}

	@Override
	protected Object getEntityToSendWithNotification(WnsAbstractNotification notification) {
		return notification;
	}
}
