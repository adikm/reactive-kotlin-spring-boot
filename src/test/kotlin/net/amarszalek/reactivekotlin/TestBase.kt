package net.amarszalek.reactivekotlin

import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.runApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.*
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

/**
 * If you want to read my story about writing integration tests for WebFlux in Kotlin
 * visit: https://amarszalek.net/blog/2018/04/11/rant-integration-tests-spring-webflux-kotlin/
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@ExtendWith(SpringExtension::class)
class TestBase {

    protected val client = WebTestClient.bindToServer()
            .baseUrl("http://127.0.0.1:8080")
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build()

    @BeforeAll
    fun initApplication() {
        runApplication<ReactivekotlinApplication>()
    }

}
