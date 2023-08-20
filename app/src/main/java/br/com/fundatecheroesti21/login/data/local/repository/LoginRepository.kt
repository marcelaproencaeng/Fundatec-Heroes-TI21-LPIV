package br.com.fundatecheroesti21.login.data.local.repository

import android.util.Log
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import br.com.fundatecheroesti21.database.FHDatabase
import br.com.fundatecheroesti21.login.data.local.UserEntity
import br.com.fundatecheroesti21.login.data.remote.LoginResponse
import br.com.fundatecheroesti21.login.data.remote.UserRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.util.*

class LoginRepository {

    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }


    private val client =
        RetrofitNetworkClient
            .createNetworkClient()
            .create(LoginService::class.java)

    suspend fun login(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = client.getUser(email, password)
                saveUser(response)
                response.isSuccessful
            } catch (exception: Exception) {
                Log.e("login", exception.message.orEmpty())
                false
            }
        }
    }

    suspend fun createUser(name: String, email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = client.postUser(UserRequest(name, email, password))
                response.isSuccessful
            } catch (exception: Exception) {
                Log.e("login", exception.message.orEmpty())
                false
            }
        }
    }


    suspend fun getUsuario(): Int {
        return withContext(Dispatchers.IO) {
            val id: Int = database.userDao().getId()
            id
        }
    }



    suspend fun userCheckExists(userExists: Boolean): Boolean {
        return withContext(Dispatchers.IO) {
            val user = database.userDao().getUser()
            if (user == null) {
                !userExists
            }
            true
        }
    }

    private suspend fun saveUser(user: Response<LoginResponse>) {
        return withContext(Dispatchers.IO) {
            if (user.isSuccessful) {
                user.body()?.run {
                    database.userDao().insertUser(
                        userResponseToEntity()
                    )
                }
            }
        }
    }


    suspend fun getCacheDate(): Date? {
        return withContext(Dispatchers.IO) {
            database.userDao().getUserDate()
        }
    }

    suspend fun clearCache() {
        return withContext(Dispatchers.IO) {
            database.userDao().clearCache()
        }
    }

    private fun LoginResponse.userResponseToEntity(): UserEntity {
        return UserEntity(
            id = id,
            name = name,
            email = email,
            password = password,
        )
    }
}