package br.com.anibook.selecao.serviceInterface

import br.com.anibook.selecao.entity.Person
//Interface com os 'services' para o objeto 'Person'
interface PersonServiceInterface {
    fun list(): List<Person>
    fun save(person: Person): Person
    fun load(id: Long): Person
    fun delete(id: Long)
    fun put(id: Long, person: Person): Person
}