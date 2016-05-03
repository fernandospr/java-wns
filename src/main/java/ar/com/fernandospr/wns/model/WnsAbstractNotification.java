package ar.com.fernandospr.wns.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlTransient;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class WnsAbstractNotification {
	@XmlTransient
	public abstract String getType();
}
