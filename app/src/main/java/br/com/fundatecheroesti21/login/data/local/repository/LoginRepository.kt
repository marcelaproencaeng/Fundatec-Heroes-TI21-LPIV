package br.com.fundatecheroesti21.login.data.local.repository


import android.util.Log
import br.com.fundatecheroesti21.database.FHDatabase
import br.com.fundatecheroesti21.UserEntity
import br.com.fundatecheroesti21.login.data.remote.LoginResponse
import br.com.fundatecheroesti21.login.data.local.UserRequest
import br.com.fundatecheroesti21.network.RetrofitNetworkClient
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
                val response = client.createUser(
                    UserRequest(
                        name = name,
                        email = email,
                        password = password,
                    )
                )
                response.isSuccessful
            } catch (exception: Exception) {
                Log.e("login", exception.message.orEmpty())
                false
            }
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
            name = name,
            email = email,
            password = password,
        )
    }

    suspend fun userSQLite() {
        return withContext(Dispatchers.IO) {
            try {
                database.userDao().getUser()
            } catch (exception: Exception) {
                Log.e("SQLite", exception.message.orEmpty())
                false
            }

        }
    }

//        suspend fun validateCache(isTimeMaior: Boolean) {
//        val user: List<UserEntity> = database.userDao().getUser()
//        val dataCacheResponse = database.userDao().getCache().time
//        val dataNow = Date().time
//        val timeResponse = dataNow - dataCacheResponse
//        val secondsTime = timeResponse / 1000
//        val minutesTime = secondsTime / 60
//        if (minutesTime > 10) {
//            cleanCache(user, isTimeMaior)
//        }
//    }

    suspend fun userCheckExists(userExists: Boolean): Boolean {
        val user = database.userDao().getUser()
        if (user == null) {
            return !userExists
        }
        return true
    }


    fun getUserId(userIdExists:Boolean): Boolean {
        val id = database.userDao().getUserId()
        if (id == null) {

            return !userIdExists
        }
        return true
    }

//    private suspend fun cleanCache(user: List<UserEntity>, isTimeMenor: Boolean): Boolean {
//        database.userDao().clearCache()
//        return !isTimeMenor;
//    }
}
