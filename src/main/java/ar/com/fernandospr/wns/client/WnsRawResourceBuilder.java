package ar.com.fernandospr.wns.client;

import javax.ws.rs.core.MediaType;

import ar.com.fernandospr.wns.model.WnsAbstractNotification;
import ar.com.fernandospr.wns.model.WnsRaw;

import com.sun.jersey.api.client.WebResource.Builder;

public class WnsRawResourceBuilder extends WnsResourceBuilder {	
	
	@Override
	protected void addRequiredHeaders(Builder webResourceBuilder, String type, String accessToken) {
		super.addRequiredHeaders(webResourceBuilder, type, accessToken);
		webResourceBuilder.type(MediaType.APPLICATION_OCTET_STREAM);
	}

	@Override
	protected Object getEntityToSendWithNotification(WnsAbstractNotification notification) {
		return ((WnsRaw)notification).getStreamAsByteArray();
	}
}
