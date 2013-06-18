package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

// http://msdn.microsoft.com/en-us/library/windows/apps/br230842.aspx

@XmlRootElement(name = "audio")
public class WnsAudio {
	
	@XmlAttribute
	public String src;
	
	@XmlAttribute
	public Boolean loop;
	
	@XmlAttribute
	public Boolean silent;
}
