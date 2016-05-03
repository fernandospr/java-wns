package ar.com.fernandospr.wns.client;

import ar.com.fernandospr.wns.model.WnsToast;
import ar.com.fernandospr.wns.model.builders.WnsToastBuilder;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import junit.framework.TestCase;

import javax.ws.rs.core.MediaType;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class WnsTest extends TestCase {

    private WireMockServer wireMockServer;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        wireMockServer = new WireMockServer(wireMockConfig().port(8089));
        wireMockServer.start();
        WireMock.configureFor("localhost", 8089);

        // Stub server response for access token
        stubFor(post(urlEqualTo("/accesstoken.srf"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON)
                        .withBody("{\"access_token\":\"access_token\",\"token_type\":\"token_type\",\"expires_in\":9999}")));
    }

    @Override
    protected void tearDown() throws Exception {
        wireMockServer.stop();
        super.tearDown();
    }

    public void testXmlSerialization() {
        WnsToastBuilder builder = new WnsToastBuilder();
        builder.bindingTemplateToastText02("a", "b");

        WnsToast toast = builder.build();
        WnsClient client = new WnsClient("sid", "client secret", true) {
            @Override
            protected String getAuthenticationUri() {
                return "http://localhost:8089/accesstoken.srf";
            }
        };
        WnsResourceBuilder xmlResourceBuilder = new WnsXmlResourceBuilder();

        // Stub server response for push
        stubFor(post(urlEqualTo("/fakechannel"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("OK")));

        client.push(xmlResourceBuilder, "http://localhost:8089/fakechannel", toast, 5, null);

        // Verify it reached with the correct XML content
        verify(postRequestedFor(urlEqualTo("/fakechannel"))
                .withRequestBody(equalToXml("<toast><visual><binding template=\"ToastText02\"><text id=\"1\">a</text><text id=\"2\">b</text></binding></visual></toast>")));
    }
}
