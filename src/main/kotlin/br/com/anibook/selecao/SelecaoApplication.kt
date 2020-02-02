package br.com.anibook.selecao

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication
class SelecaoApplication {

    @PostConstruct
    fun init() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"))
    }

}
fun main(args: Array<String>) {
//    runApplication<SelecaoApplication>(*args)
    SpringApplication.run(SelecaoApplication::class.java, *args)
}
