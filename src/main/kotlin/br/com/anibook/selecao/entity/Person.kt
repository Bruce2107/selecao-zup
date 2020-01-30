package br.com.anibook.selecao.entity

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0L,
                  var name: String = "",
                  var cpf: String = "",
                  var address: String = "",
                  var nasc: Date? = null) {
}