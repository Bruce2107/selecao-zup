package br.com.anibook.selecao.service

import br.com.anibook.selecao.entity.Person
import br.com.anibook.selecao.exception.NotFoundException
import br.com.anibook.selecao.exception.ServiceException
import br.com.anibook.selecao.repository.PersonRepository
import br.com.anibook.selecao.serviceInterface.PersonServiceInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
//Implementação da interface
@Service
class PersonService : PersonServiceInterface {
    @Autowired
    lateinit var personRepository: PersonRepository
    //Service para retorno de todos os dados
    @Throws(ServiceException::class)
    override fun list(): List<Person> {
        try {
            return personRepository.findAll()
        } catch (e: Exception) {
            throw ServiceException(e.message.toString())
        }
    }
    //Service para salvar uma nova 'Person'
    @Throws(ServiceException::class)
    override fun save(person: Person): Person {
        try {
            return personRepository.save(person)
        } catch (e: Exception) {
            throw ServiceException(e.message.toString())
        }
    }
    //Service para buscar os dados de um objeto pelo id
    @Throws(ServiceException::class, NotFoundException::class)
    override fun load(id: Long): Person {
        val optional: Optional<Person>
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
    //Service para remoção de um dado a partir de seu id
    @Throws(ServiceException::class, NotFoundException::class)
    override fun delete(id: Long) {
        val optional: Optional<Person>
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