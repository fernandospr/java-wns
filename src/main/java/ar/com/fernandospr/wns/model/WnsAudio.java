package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlAttribute;

// http://msdn.microsoft.com/en-us/library/windows/apps/br230842.aspx
public class WnsAudio {
	
	@XmlAttribute
	public String src;
	
	@XmlAttribute
	public Boolean loop;
	
	@XmlAttribute
	public Boolean silent;
}
