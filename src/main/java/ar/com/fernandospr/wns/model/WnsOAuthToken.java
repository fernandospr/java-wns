package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * From <a href="http://msdn.microsoft.com/en-us/library/windows/apps/hh913756.aspx">http://msdn.microsoft.com/en-us/library/windows/apps/hh913756.aspx</a> 
 */
@XmlRootElement
public class WnsOAuthToken {
	public String access_token;
	public String token_type;
	public Integer expires_in;
}
