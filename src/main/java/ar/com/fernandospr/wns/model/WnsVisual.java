package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * For toasts <a href="http://msdn.microsoft.com/en-us/library/windows/apps/br230847.aspx">http://msdn.microsoft.com/en-us/library/windows/apps/br230847.aspx</a>
 * <p>
 * For tiles <a href="https://msdn.microsoft.com/en-us/library/windows/apps/br212857.aspx">https://msdn.microsoft.com/en-us/library/windows/apps/br212857.aspx</a>
 */
@XmlRootElement(name = "visual")
public class WnsVisual {
	
	@XmlAttribute
	public Integer version;
	
	@XmlAttribute
	public String lang;
	
	@XmlAttribute
	public String baseUri;
	
	@XmlAttribute
	public String branding;
	
	@XmlAttribute
	public Boolean addImageQuery;
	
	@XmlElement(name = "binding")
	public WnsBinding binding;

	/**
	 * Only used in tiles
	 */
	@XmlAttribute
	public String contentId;
}
