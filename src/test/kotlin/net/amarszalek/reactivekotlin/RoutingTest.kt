package net.amarszalek.reactivekotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import reactor.core.publisher.Mono
import java.lang.Exception

class RoutingTest : TestBase() {

    @Test
    fun get() {
        val retrieve = client.get().uri("/books/{title}", "Title5")
                .accept(MediaType.APPLICATION_JSON).retrieve()

        val bodyToMono = retrieve
                .onStatus(HttpStatus::isError, { Mono.error(Exception()) })
                .bodyToMono(Book::class.java)

        val book = bodyToMono.block()!!
        assertEquals("Title5", book.title)

    }


//    @Test
//    fun `Receive a stream of users via Server-Sent-Events`() {
//        val responseBody: Flux<Book> = client.get().uri("/books")
//                .accept(MediaType.TEXT_EVENT_STREAM)
//                .exchange().returnResult(Book::class.java).responseBody
//
//        StepVerifier.create(responseBody)
//                .consumeNextWith({ book -> println(book) })
//                .thenCancel()
//                .verify()
//    }
}