package br.com.fundatecheroesti21.login.data.local

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
)
