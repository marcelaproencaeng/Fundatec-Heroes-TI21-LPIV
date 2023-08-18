package br.com.fundatecheroesti21.character.data.repository;

import br.com.fundatecheroesti21.database.FHDatabase;
import br.com.fundatecheroesti21.network.RetrofitNetworkClient;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.withContext;

public class CharacterRepository {
    private val database:FHDatabase by lazy {
        FHDatabase.getInstance()
    }
    private val client =
            RetrofitNetworkClient
                    .createNetworkClient()
                    .create(CharacterService::class.java)
    suspend fun addPersonagem(id:Int, characterRequest:CharacterRequest):Boolean {
            return withContext(Dispatchers.IO) {
                val response = client.criarPersonagem(id, characterRequest)
                response.isSuccessful
            }
        }
    }
