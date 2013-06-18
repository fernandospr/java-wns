package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

// http://msdn.microsoft.com/en-us/library/windows/apps/br212849.aspx

@XmlRootElement(name = "badge")
public class WnsBadge extends WnsAbstractNotification {
	
	@XmlAttribute
	public String value;
	
	@XmlAttribute
	public Integer version;
}
