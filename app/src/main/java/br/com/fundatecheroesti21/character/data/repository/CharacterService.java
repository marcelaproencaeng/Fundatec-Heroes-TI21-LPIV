package br.com.fundatecheroesti21.character.data.repository;



import br.com.fundatecheroesti21.character.data.remote.CharacterResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
 interface CharacterService  {

     @POST("api/character/{id}")
     suspend fun criarPersonagem(@Path("id") id: Int, @Body characterRequest: CharacterRequest): Response<CharacterRequest>

     @GET("api/character/{id}")
     suspend fun getPersonagens(@Path ("id") id: Int): Response<CharacterResponse>

     @DELETE("api/transaction/{id}")
     suspend fun deletarPersonagem(@Path ("id") id: Int)
}

