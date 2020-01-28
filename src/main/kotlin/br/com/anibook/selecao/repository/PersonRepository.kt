package br.com.anibook.selecao.repository

import br.com.anibook.selecao.entity.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<PersonEntity, Long> {
}