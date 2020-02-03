package br.com.anibook.selecao.person

import br.com.anibook.selecao.exception.NotFoundException
import br.com.anibook.selecao.exception.ServiceException
import br.com.anibook.selecao.utils.Constants.Companion.NOT_FOUND
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonServiceImpl : PersonService {
    @Autowired
    lateinit var personRepository: PersonRepository

    @Throws(ServiceException::class)
    override fun list(): List<Person> = try {
        personRepository.findAll()
    } catch (e: Exception) {
        throw ServiceException(e.message.toString())
    }

    @Throws(ServiceException::class)
    override fun save(person: Person): Person {
        try {
            return personRepository.save(person)
        } catch (e: Exception) {
            throw ServiceException(e.message.toString())
        }
    }

    @Throws(ServiceException::class, NotFoundException::class)
    override fun load(id: Long): Person {
        val optional: Optional<Person>
        try {
            optional = personRepository.findById(id)
        } catch (e: Exception) {
            throw ServiceException(e.message.toString())
        }
        if (!optional.isPresent) {
            throw NotFoundException(NOT_FOUND)
        }

        return optional.get()
    }

    @Throws(ServiceException::class, NotFoundException::class)
    override fun delete(id: Long) {
        val optional: Optional<Person>
        try {
            optional = personRepository.findById(id)
        } catch (e: Exception) {
            throw ServiceException(e.message.toString())
        }
        if (!optional.isPresent) {
            throw NotFoundException(NOT_FOUND)
        } else {
            try {
                return personRepository.deleteById(id)
            } catch (e: Exception) {
                throw ServiceException(e.message.toString())
            }
        }
    }

    @Throws(NotFoundException::class, ServiceException::class)
    override fun put(id: Long, person: Person): Person {
        val optional: Optional<Person>
        try {
            optional = personRepository.findById(id)
        } catch (e: Exception) {
            throw ServiceException(message = e.message.toString())
        }
        return if (optional.isPresent) {
            val personTemp = optional.get()
            with(personTemp, {
                name = person.name
                cpf = person.cpf
                address = person.address
                nasc = person.nasc
            })
            personTemp
        } else throw NotFoundException(NOT_FOUND)
    }
}