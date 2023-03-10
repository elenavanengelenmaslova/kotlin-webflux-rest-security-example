package nl.vintik.sample.spring.resource

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.security.test.context.support.WithAnonymousUser
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class HelloControllerTest {
    @Autowired
    private lateinit var webClient: WebTestClient

    @Test
    @WithMockUser
    fun `should say Hello World`() {
        webClient
            .get()
            .uri("/v1/hello")
            .header(HttpHeaders.AUTHORIZATION, "Bearer test")
            .exchange()
            .expectStatus()
            .is2xxSuccessful
    }

    @Test
    @WithAnonymousUser
    fun `should deny access`() {
        webClient
            .get()
            .uri("/v1/hello")
            .exchange()
            .expectStatus()
            .isUnauthorized
    }
}