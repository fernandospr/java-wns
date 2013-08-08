package ar.com.fernandospr.wns.client;

import javax.ws.rs.core.MediaType;

import ar.com.fernandospr.wns.model.WnsAbstractNotification;

import com.sun.jersey.api.client.WebResource.Builder;

public class WnsXmlResourceBuilder extends WnsResourceBuilder {
	
	@Override
	protected void addRequiredHeaders(Builder webResourceBuilder, String type, String accessToken) {
		super.addRequiredHeaders(webResourceBuilder, type, accessToken);
		webResourceBuilder.type(MediaType.TEXT_XML);
	}

	@Override
	protected Object getEntityToSendWithNotification(WnsAbstractNotification notification) {
		return notification;
	}
}
