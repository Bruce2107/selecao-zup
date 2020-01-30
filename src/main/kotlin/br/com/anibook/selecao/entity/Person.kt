package br.com.anibook.selecao.entity

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0L,
                  val name: String = "",
                  val cpf: String = "",
                  val address: String = "",
                  val nasc: Date? = null) {
}