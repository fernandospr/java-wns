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
    
    private String protocol;
    private String host;
    private int port;
    private String user;
    private String pass;

    public WnsProxyProperties(String protocol, String host, int port, String user, String pass) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    } 
}
