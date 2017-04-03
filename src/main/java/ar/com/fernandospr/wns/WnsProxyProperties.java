/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.fernandospr.wns;

/**
 *
 * @author harishankar
 */
public class WnsProxyProperties {

    private final String uri;
    private final String user;
    private final String pass;

    public WnsProxyProperties(String uri, String user, String pass) {
        this.uri = uri;
        this.user = user;
        this.pass = pass;
    }

    public WnsProxyProperties(String protocol, String host, int port, String user, String pass) {
        this(protocol + "://" + host + ":" + port, user, pass);
    }

    public String getUri() {
        return uri;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    } 
}
