package br.com.anibook.selecao.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "pessoa")
data class PersonEntity(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0L,
                        val name: String = "",
                        val cpf: String = "",
                        val address: String = "",
                        val date: LocalDate? = null) {
}