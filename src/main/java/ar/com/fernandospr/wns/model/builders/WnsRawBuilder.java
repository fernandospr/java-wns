package ar.com.fernandospr.wns.model.builders;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import ar.com.fernandospr.wns.model.WnsRaw;

public class WnsRawBuilder {
	private WnsRaw raw;

	public WnsRawBuilder() {
		this.raw = new WnsRaw();
	}
	
	public WnsRawBuilder stream(byte[] stream) {
		this.raw.stream = stream.clone();
		return this;
	}
	
	public WnsRawBuilder stream(ByteArrayInputStream stream) {
		try {
			byte[] array = new byte[stream.available()];
			stream.read(array);
			return this.stream(array);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public WnsRaw build() {
		return this.raw;
	}
}
