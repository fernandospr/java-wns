package ar.com.fernandospr.wns;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WnsOAuthToken {
	public String access_token;
	public String token_type;
	public Integer expires_in;
	
	public WnsOAuthToken() {}

	public WnsOAuthToken(String access_token, String token_type,
			Integer expires_in) {
		this.access_token = access_token;
		this.token_type = token_type;
		this.expires_in = expires_in;
	}

}
