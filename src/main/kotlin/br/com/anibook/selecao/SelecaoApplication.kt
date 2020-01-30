package br.com.anibook.selecao

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SelecaoApplication{
//class SelecaoApplication : CommandLineRunner {
//    @Autowired
//    lateinit var personRepository: PersonRepository
//
//    override fun run(vararg args: String?) {
//        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
//        val personEntity1 = PersonEntity(1, "Eduardo", "47535061850", "pires de baixo", LocalDate.parse("21-07-2001", formatter))
//        val personEntity2 = PersonEntity(2, "Vitoria", "47535061851", "pires de baixo", LocalDate.parse("11-03-2004", formatter))
//        val personEntity3 = PersonEntity(3, "Antonio", "47535061852", "pires de baixo", LocalDate.parse("21-07-1969", formatter))
//        val personEntity4 = PersonEntity(4, "Mariza", "47535061853", "pires de baixo", LocalDate.parse("12-05-1968", formatter))
//		with(personRepository) {
//			save(personEntity1)
//			save(personEntity2)
//			save(personEntity3)
//			save(personEntity4)
//		}
//	}

}

fun main(args: Array<String>) {
    runApplication<SelecaoApplication>(*args)
}
