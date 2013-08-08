package ar.com.fernandospr.wns.model;

import java.io.ByteArrayInputStream;

import ar.com.fernandospr.wns.model.types.WnsNotificationType;

public class WnsRaw extends WnsAbstractNotification {
	public byte[] stream;
	
	public ByteArrayInputStream getStreamAsByteArray() {
		return new ByteArrayInputStream(stream);
	}

	@Override
	public String getType() {
		return WnsNotificationType.RAW;
	}
}
