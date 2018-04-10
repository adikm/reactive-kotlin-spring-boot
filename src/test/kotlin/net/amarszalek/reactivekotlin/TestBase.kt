package net.amarszalek.reactivekotlin

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.runApplication
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class TestBase {

    protected val client: WebClient = WebClient.builder()
            .baseUrl("http://127.0.0.1:8080")
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build()

    @BeforeAll
    fun initApplication() {
        runApplication<ReactivekotlinApplication>()
    }
}
