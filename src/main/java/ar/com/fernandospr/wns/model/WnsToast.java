package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

// http://msdn.microsoft.com/en-us/library/windows/apps/br230846.aspx
public class WnsToast {
	
	@XmlAttribute
	public String launch;
	
	@XmlAttribute
	public String duration;
	
	@XmlElement(name = "visual")
	public WnsVisual visual;
	
	@XmlElement(name = "audio")
	public WnsAudio audio;
}
