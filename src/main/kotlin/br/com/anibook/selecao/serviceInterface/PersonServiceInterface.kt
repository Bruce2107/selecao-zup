package br.com.anibook.selecao.serviceInterface

import br.com.anibook.selecao.entity.PersonEntity

interface PersonServiceInterface {
    fun list(): List<PersonEntity>
    fun save(personEntity: PersonEntity): PersonEntity
    fun load(id: Long): PersonEntity
    fun delete(id: Long)
}