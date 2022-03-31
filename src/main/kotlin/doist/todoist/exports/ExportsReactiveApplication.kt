package doist.todoist.exports

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExportsReactiveApplication

fun main(args: Array<String>) {
    runApplication<ExportsReactiveApplication>(*args)
}
