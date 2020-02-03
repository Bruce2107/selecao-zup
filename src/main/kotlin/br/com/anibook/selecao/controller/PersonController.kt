package br.com.anibook.selecao.controller

import br.com.anibook.selecao.entity.Person
import br.com.anibook.selecao.exception.NotFoundException
import br.com.anibook.selecao.exception.ServiceException
import br.com.anibook.selecao.service.PersonService
import br.com.anibook.selecao.utils.Constants.Companion.URL_BASE_PERSON
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.*

@RestController
@RequestMapping(URL_BASE_PERSON)
class PersonController {
    @Autowired
    lateinit var personService: PersonService

    //Controller para busca de todos os dados
    @GetMapping()
    fun list(): ResponseEntity<List<Person>> =
            try {
                ResponseEntity.ok(personService.list())
            } catch (e: Exception) {
                ResponseEntity.badRequest().build()
            }

    //Controller para busca de uma 'Person' pelo seu id
    @GetMapping("/{id}")
    fun load(@PathVariable("id") id: Long): ResponseEntity<Person> {
        return try {
            ResponseEntity.ok(personService.load(id))
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    //Controller para adição de uma nova 'Person'
    @PostMapping
    fun insert(@RequestBody person: Person): ResponseEntity<Any> {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"))
        println(person.nasc)
        return try {
            personService.save(person)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", """${URL_BASE_PERSON}/${person.id}""")
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        } catch (e: ServiceException) {
            ResponseEntity.badRequest().build()
        }
    }

    //Controller para a remoção de um dado
    @DeleteMapping("/{id}")
    fun remove(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(personService.delete(id))
        } catch (e: ServiceException) {
            ResponseEntity.badRequest().build()
        } catch (e: NotFoundException) {
            ResponseEntity.notFound().build()
        }
    }

    //    //Controller para edição de uma 'Person'
    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody person: Person): ResponseEntity<Any> {
        person.id = id
        person.nasc
        val person2: Person = personService.put(id, person)
        return try {
            ResponseEntity.ok(personService.save(person2))
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }


//    @PutMapping("/{id}")
//    fun update(@PathVariable("id") id: Long,
//               @RequestParam(value = "name") name: String,
//               @RequestParam(value = "cpf") cpf: String,
//               @RequestParam(value = "address") address: String,
//               @RequestParam(value = "nasc") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) nasc: LocalDate): ResponseEntity<Any> {
//        val person2: Person = personService.put(id, Person(id, name, cpf, address, nasc))
//        return try {
//            ResponseEntity.ok(personService.save(person2))
//        } catch (e: Exception) {
//            ResponseEntity.badRequest().build()
//        }
//    }
}