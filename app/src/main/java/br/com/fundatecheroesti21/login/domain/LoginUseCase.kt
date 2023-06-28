package br.com.fundatecheroesti21.login.domain

import br.com.fundatecheroesti21.login.data.remote.repository.LoginRepository

class LoginUseCase {
    private val repository by lazy { LoginRepository() }

    suspend fun login(email: String, password: String): Boolean {
        return repository.login(email = email, password = password)
    }
}