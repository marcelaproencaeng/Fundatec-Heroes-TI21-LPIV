package br.com.fundatecheroesti21.login.data.remote.repository

import br.com.fundatecheroesti21.login.data.remote.LoginResponse
import br.com.fundatecheroesti21.login.data.remote.UserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @GET("/api/login")
    suspend fun getUser(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<LoginResponse>

    @POST("/api/login")
    suspend fun createUser(
        @Body userRequest: UserRequest
    ): Response<LoginResponse>
}