package net.amarszalek.reactivekotlin

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class Routing {

    @Bean
    fun booksRouter(handler: BooksHandler) = router {
        ("/books" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("/", handler::getAll)
            GET("/{title}", handler::getBook)
            POST("/", handler::addBook)
        }
    }

}