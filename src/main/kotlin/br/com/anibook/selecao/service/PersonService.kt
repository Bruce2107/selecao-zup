package br.com.anibook.selecao.service

import br.com.anibook.selecao.entity.PersonEntity
import br.com.anibook.selecao.exception.NotFoundException
import br.com.anibook.selecao.exception.ServiceException
import br.com.anibook.selecao.repository.PersonRepository
import br.com.anibook.selecao.serviceInterface.PersonServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService : PersonServiceInterface {
    @Autowired
    lateinit var personRepository: PersonRepository

    @Throws(ServiceException::class)
    override fun list(): List<PersonEntity> {
        try {
            return personRepository.findAll()
        } catch (e: Exception) {
            throw ServiceException(e.message.toString())
        }
    }

    @Throws(ServiceException::class)
    override fun save(personEntity: PersonEntity): PersonEntity {
        try {
            return personRepository.save(personEntity)
        } catch (e: Exception) {
            throw ServiceException(e.message.toString())
        }
    }

    @Throws(ServiceException::class, NotFoundException::class)
    override fun load(id: Long): PersonEntity {
        val optional: Optional<PersonEntity>
        try {
            optional = personRepository.findById(id)
        } catch (e: Exception) {
            throw ServiceException(e.message.toString())
        }
        if (!optional.isPresent) {
            throw NotFoundException("Person not found")
        }

        return optional.get()
    }

    @Throws(ServiceException::class, NotFoundException::class)
    override fun delete(id: Long) {
        val optional: Optional<PersonEntity>
        try {
            optional = personRepository.findById(id)
        } catch (e: Exception) {
            throw ServiceException(e.message.toString())
        }
        if (!optional.isPresent) {
            throw NotFoundException("Person not found")
        } else {
            try {
                return personRepository.deleteById(id)
            } catch (e: Exception) {
                throw ServiceException(e.message.toString())
            }
        }
    }
}