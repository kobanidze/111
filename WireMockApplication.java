package RESTMocks;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class WireMockApplication {

    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();
        WireMock.configureFor("localhost", 8080);

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/hello-world"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("Hello, world")));

        Runtime.getRuntime().addShutdownHook(new Thread(wireMockServer::stop));
       }
}
