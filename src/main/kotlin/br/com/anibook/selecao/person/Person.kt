package br.com.anibook.selecao.person

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0L,
                  var name: String = "",
                  var cpf: String = "",
                  var address: String = "",
                  var nasc: LocalDate? = null) {
}