package br.com.fundatecheroesti21.login.domain

import br.com.fundatecheroesti21.login.data.remote.repository.LoginRepository

class LoginUseCase {
    private val repository by lazy { LoginRepository() }

    suspend fun login(email: String, password: String): Boolean {
        return repository.login(email = email, password = password)
    }

    suspend fun isUserExist(userExists: Boolean): Boolean {
        repository.userCheckExists(userExists);
        return userExists
    }

    suspend fun validateLogin(isTimeMaior: Boolean): Boolean {
        repository.validateCache(isTimeMaior)
        return isTimeMaior


    }

}