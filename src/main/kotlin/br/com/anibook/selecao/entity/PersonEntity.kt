package br.com.anibook.selecao.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pessoa")
data class PersonEntity(@Id @GeneratedValue val id: Long, val name: String = "", val cpf: String = "", val address: String = "") {
}