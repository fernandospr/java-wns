package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ar.com.fernandospr.wns.model.types.WnsNotificationType;

/**
 * From <a href="http://msdn.microsoft.com/en-us/library/windows/apps/br230846.aspx">http://msdn.microsoft.com/en-us/library/windows/apps/br230846.aspx</a>
 */
@XmlRootElement(name = "toast")
public class WnsToast extends WnsAbstractNotification {
	
	@XmlAttribute
	public String launch;
	
	@XmlAttribute
	public String duration;
	
	@XmlElement(name = "visual")
	public WnsVisual visual;
	
	@XmlElement(name = "audio")
	public WnsAudio audio;

	@XmlElement(name = "commands")
	public WnsToastCommands commands;

	@Override
	public String getType() {
		return WnsNotificationType.TOAST;
	}
}
