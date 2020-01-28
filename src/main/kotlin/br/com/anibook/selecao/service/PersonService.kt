package br.com.anibook.selecao.service

import br.com.anibook.selecao.entity.PersonEntity
import br.com.anibook.selecao.serviceInterface.PersonServiceInterface

class PersonService: PersonServiceInterface {
    override fun list(): List<PersonEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(personEntity: PersonEntity): PersonEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun load(id: Long): PersonEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}