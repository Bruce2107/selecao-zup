package br.com.anibook.selecao.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0L,
                  var name: String = "",
                  var cpf: String = "",
                  var address: String = "",
//                  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                  var nasc: LocalDate? = null) {
}