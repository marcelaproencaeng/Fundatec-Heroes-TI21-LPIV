package br.com.fundatecheroesti21.character.data;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class CharacterService {
    @POST("api/character/{id}")
    suspend fun criarPersonagem(
            @Path("id")id: Int,
            @Body characterRequest: CharacterRequest)
    ): Response<CharacterRequest>

    @GET("api/character/{id}")
    suspend fun getPersonagens(@Path ("id") id: Int): Response<CharacterResponse>
}

