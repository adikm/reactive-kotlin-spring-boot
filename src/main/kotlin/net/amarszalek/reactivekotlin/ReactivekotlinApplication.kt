package net.amarszalek.reactivekotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactivekotlinApplication

fun main(args: Array<String>) {
    runApplication<ReactivekotlinApplication>(*args)
}