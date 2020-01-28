package br.com.anibook.selecao.controller

import br.com.anibook.selecao.entity.PersonEntity
import br.com.anibook.selecao.exception.NotFoundException
import br.com.anibook.selecao.exception.ServiceException
import br.com.anibook.selecao.service.PersonService
import br.com.anibook.selecao.utils.Constants
import br.com.anibook.selecao.utils.Constants.Companion.URL_BASE_PERSON
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(URL_BASE_PERSON)
class PersonController {
    @Autowired
    lateinit var personService: PersonService

    @GetMapping()
    fun list(): ResponseEntity<List<PersonEntity>> {
        return try {
            ResponseEntity.ok(personService.list())
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") id: Long): ResponseEntity<PersonEntity> {
        return try {
            ResponseEntity.ok(personService.load(id))
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping()
    fun insert(@RequestBody personEntity: PersonEntity): ResponseEntity<Any> {
        return try {
            personService.save(personEntity)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", """${URL_BASE_PERSON}/${personEntity.id}""")
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        } catch (e: ServiceException) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("")
    fun upd(@RequestBody personEntity: PersonEntity): ResponseEntity<Any> {
        return try {
            personService.save(personEntity)
            ResponseEntity.ok().build()
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
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
}