package br.com.fundatecheroesti21.home.presentation.model

import java.time.LocalDate

data class Characters(
    val name: String,
    val description: String,
    val age: Int,
    val date: LocalDate,
    val url: String,
    val marvel_Dc: Enum,
    val heroes_villains: Enum,


    ) {
    enum class Enum { Marvel, DC, Heroes, Villains }
}
