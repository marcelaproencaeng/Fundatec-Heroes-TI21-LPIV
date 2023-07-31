package br.com.fundatecheroesti21.login.domain

import br.com.fundatecheroesti21.login.data.local.repository.LoginRepository
import br.com.fundatecheroesti21.profile.data.local.LocalData
import br.com.fundatecheroesti21.profile.data.local.User

class LoginUseCase {
    //    Tela de login, ao fazer o login devemos salvar o id do usuário no banco de dados,
//    pois vamos precisar desse id para salvar/buscar/deletar os personagens
    private val repository by lazy { LoginRepository() }
    private val localData by lazy { LocalData() }

    suspend fun login(email: String, password: String): Boolean {
        return repository.login(email = email, password = password)
    }

    suspend fun isUserExist(userExists: Boolean): Boolean {
        repository.userCheckExists(userExists);
        return userExists
    }

    suspend fun saveUserLocal(email: String, password: String) {
        val loginResponse = repository.login(email, password)
        val it = repository.getUserId(idExists = true)
        val user = loginResponse?.let {
            User(
                it.idExists,
                loginResponse.name,
                loginResponse.email,
                loginResponse.password
            )
        }
        // TODO: validação de existência de usuário na API
        localData.saveUser(user!!)

    }

//    private suspend fun getUser(): String {
//        repository.userCheckExists(userExists: Boolean)
//        return true
//
//    }


    suspend fun validateLogin(isTimeMaior: Boolean): Boolean {
        repository.validateCache(isTimeMaior)
        return isTimeMaior


    }

    fun getUserId(): Int {
        return repository.getUserId()
    }

}