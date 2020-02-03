package br.com.anibook.selecao

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication
class SelecaoApplication
fun main(args: Array<String>) {
    SpringApplication.run(SelecaoApplication::class.java, *args)
}
