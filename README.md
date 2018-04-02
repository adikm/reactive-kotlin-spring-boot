# Reactive Kotlin + Spring Boot 2

Reactive application built using Kotlin and Spring WebFlux.
This is just a showcase project for demonstration of reactive possibilities and Server-Sent Events in Kotlin together with Spring Boot.


To learn more, visit this [blog post](http://amarszalek.net/blog/2018/04/02/reactive-web-services-kotlin-spring-boot-2/)
## Running

To run this application, simply execute:

```shell
mvn spring-boot:run
```
Remember that you should have a MongoDB server running on host and port.

## Endpoints

After running the application, the public instance should be available at http://localhost:8080
As for now, it offers the following endpoints:
* `GET /books/{title}` returns a book with given title
* `POST /books` with a request body containg title and author will save a new book to the storage
* `GET /books` will give you all the books in the storage using Server-Sent Event Stream
