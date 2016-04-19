package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlTransient;

public abstract class WnsAbstractNotification {
	@XmlTransient
	public abstract String getType();
}
