package ar.com.fernandospr.wns.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * From <a href="http://msdn.microsoft.com/en-us/library/windows/apps/br230843.aspx">http://msdn.microsoft.com/en-us/library/windows/apps/br230843.aspx</a>
 */
@XmlRootElement(name = "binding")
public class WnsBinding {
	
	@XmlAttribute
	public String template;
	
	@XmlAttribute
	public String fallback;
	
	@XmlAttribute
	public String lang;
	
	@XmlAttribute
	public String baseUri;
	
	@XmlAttribute
	public String branding;
	
	@XmlAttribute
	public Boolean addImageQuery;
	
	@XmlElement(name = "image")
	public List<WnsImage> images;
	
	@XmlElement(name = "text")
	public List<WnsText> texts;
}
