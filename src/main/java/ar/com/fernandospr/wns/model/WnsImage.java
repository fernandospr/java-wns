package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

// http://msdn.microsoft.com/en-us/library/windows/apps/br230844.aspx

@XmlRootElement(name = "image")
public class WnsImage {
	
	@XmlAttribute
	public Integer id;
	
	@XmlAttribute
	public String src;
	
	@XmlAttribute
	public String alt;
	
	@XmlAttribute
	public Boolean addImageQuery;
}
