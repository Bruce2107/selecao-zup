package br.com.anibook.selecao.person

interface PersonService {
    fun list(): List<Person>
    fun save(person: Person): Person
    fun load(id: Long): Person
    fun delete(id: Long)
    fun put(id: Long, person: Person): Person
}