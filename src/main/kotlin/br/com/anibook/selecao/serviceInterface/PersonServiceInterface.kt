package br.com.anibook.selecao.serviceInterface

import br.com.anibook.selecao.entity.PersonEntity
//Interface com os 'services' para o objeto 'Person'
interface PersonServiceInterface {
    fun list(): List<PersonEntity>
    fun save(personEntity: PersonEntity): PersonEntity
    fun load(id: Long): PersonEntity
    fun delete(id: Long)
}