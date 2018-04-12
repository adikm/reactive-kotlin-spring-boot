package net.amarszalek.reactivekotlin

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * If you want to read my story about writing integration tests for WebFlux in Kotlin
 * visit: https://amarszalek.net/blog/2018/04/11/rant-integration-tests-spring-webflux-kotlin/
 */
class ReactivekotlinApplicationTests : TestBase() {

    @Autowired
    private lateinit var repository: BookRepository

    @Test
    fun `Get book by Title`() {
        val bookTitle = "Title5"
        repository.save(Book(title = bookTitle, author = "Author"))

        client.get().uri("/books/{title}", bookTitle)
                .exchange().expectStatus().isOk
                .expectBody()
                .jsonPath("$.title").isEqualTo(bookTitle)
    }
}
