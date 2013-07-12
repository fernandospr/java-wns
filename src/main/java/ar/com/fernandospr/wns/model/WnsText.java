package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * From <a href="http://msdn.microsoft.com/en-us/library/windows/apps/br230845.aspx">http://msdn.microsoft.com/en-us/library/windows/apps/br230845.aspx</a>
 */
@XmlRootElement(name = "text")
public class WnsText {
	
	@XmlAttribute
	public Integer id;
	
	@XmlAttribute
	public String lang;
	
	@XmlValue
	public String value;
}
