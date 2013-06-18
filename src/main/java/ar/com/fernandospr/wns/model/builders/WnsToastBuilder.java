package ar.com.fernandospr.wns.model.builders;

import ar.com.fernandospr.wns.model.WnsToast;

public class WnsToastBuilder {
	private WnsToast toast;
	
	public WnsToastBuilder() {
		this.toast = new WnsToast();
	}
	
	public WnsToast build() {
		return this.toast;
	}
}