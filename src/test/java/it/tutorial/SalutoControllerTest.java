package it.tutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestRestTemplate
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SalutoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate http;

    @Test
    void endpointRestituisceUnSaluto() {
        String risposta = http.getForObject("http://localhost:" + port + "/api/saluto", String.class);

        assertThat(risposta).contains("Ciao, Marta!");
    }
}
