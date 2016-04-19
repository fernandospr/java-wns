package ar.com.fernandospr.wns.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * From <a href="http://msdn.microsoft.com/en-us/library/windows/apps/br230843.aspx">http://msdn.microsoft.com/en-us/library/windows/apps/br230843.aspx</a>
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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

	@JacksonXmlElementWrapper(useWrapping=false)
	@XmlElement(name = "image")
	public List<WnsImage> images;

	@JacksonXmlElementWrapper(useWrapping=false)
	@XmlElement(name = "text")
	public List<WnsText> texts;
}
