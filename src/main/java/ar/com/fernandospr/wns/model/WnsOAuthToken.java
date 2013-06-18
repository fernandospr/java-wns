package ar.com.fernandospr.wns.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WnsOAuthToken {
	public String access_token;
	public String token_type;
	public Integer expires_in;
}
