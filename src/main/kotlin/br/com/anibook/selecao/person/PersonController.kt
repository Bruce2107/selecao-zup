package br.com.anibook.selecao.person

import br.com.anibook.selecao.exception.NotFoundException
import br.com.anibook.selecao.exception.ServiceException
import br.com.anibook.selecao.utils.Constants.Companion.URL_BASE_PERSON
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(URL_BASE_PERSON)
class PersonController {

    @Autowired
    lateinit var personServiceImpl: PersonServiceImpl

    @GetMapping()
    fun list(): ResponseEntity<List<Person>> =
            try {
                ResponseEntity.ok(personServiceImpl.list())
            } catch (e: Exception) {
                ResponseEntity.badRequest().build()
            }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") id: Long): ResponseEntity<Person> {
        return try {
            ResponseEntity.ok(personServiceImpl.load(id))
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun insert(@RequestBody person: Person): ResponseEntity<Any> {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"))
        println(person.nasc)
        return try {
            personServiceImpl.save(person)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", """${URL_BASE_PERSON}/${person.id}""")
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        } catch (e: ServiceException) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    fun remove(@PathVariable("id") id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(personServiceImpl.delete(id))
        } catch (e: ServiceException) {
            ResponseEntity.badRequest().build()
        } catch (e: NotFoundException) {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody person: Person): ResponseEntity<Any> {
        person.id = id
        person.nasc
        val person2: Person = personServiceImpl.put(id, person)
        return try {
            ResponseEntity.ok(personServiceImpl.save(person2))
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}