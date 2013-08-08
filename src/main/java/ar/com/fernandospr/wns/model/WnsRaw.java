package ar.com.fernandospr.wns.model;

import java.io.ByteArrayInputStream;

public class WnsRaw extends WnsAbstractNotification {
	public byte[] stream;
	
	public ByteArrayInputStream getStreamAsByteArray() {
		return new ByteArrayInputStream(stream);
	}
}
