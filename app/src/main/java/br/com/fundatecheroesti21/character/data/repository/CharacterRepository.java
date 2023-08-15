package br.com.fundatecheroesti21.character.data.repository;

import br.com.fundatecheroesti21.character.data.CharacterService;
import br.com.fundatecheroesti21.network.RetrofitNetworkClient;
import kotlinx.coroutines.Dispatchers;

public class CharacterRepository {
    private val database:FHdatabase by lazy {
        FHdatabase.getInstance()
    }

    private val client =
            RetrofitNetworkClient
                    .createNetworkClient()
                    .create(CharacterService::class.java)

//    suspend fun addPersonagem(id:Int, characterRequest:CharacterRequest) {
//        suspend fun addPersonagem(id:Int, characterRequest:CharacterRequest):Boolean {
//            return withContext(Dispatchers.IO) {
//                val response = client.criarPersonagem(id, characterRequest)
//                response.isSuccessful
//            }
//        }
//    }
}