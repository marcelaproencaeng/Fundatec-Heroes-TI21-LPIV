package br.com.fundatecheroesti21.character.data.repository

import android.util.Log
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import br.com.fundatecheroesti21.character.data.remote.CharacterResponse
import br.com.fundatecheroesti21.database.FHDatabase
import br.com.fundatecheroesti21.home.presentation.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterRepository {
    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }

    private val client =
        RetrofitNetworkClient
            .createNetworkClient()
            .create(CharacterService::class.java)


    suspend fun getPersonagem(): List<CharacterModel> {
        return withContext(Dispatchers.IO) {
            try {
                val id = database.userDao().getId()
                val responseCharacter = client.getPersonagens(id)
                if (responseCharacter.isSuccessful) {
                    responseCharacter.body()?.mapperPersonagem() ?: emptyList()
                } else {
                    emptyList()
                }

            } catch (exception: Exception) {
                Log.e("listar Personagem", exception.message.orEmpty())
                emptyList()
            }

        }
    }

    suspend fun addPersonagem(characterRequest: CharacterRequest): Boolean {
        return withContext(Dispatchers.IO) {
            val response = client.criarPersonagem(database.userDao().getId(), characterRequest)
            response.isSuccessful
        }
    }


    private fun List<CharacterResponse>.mapperPersonagem(): List<CharacterModel> {
        return map {
            it.characterResponseToCharacterModel()
        }
    }

    private fun CharacterResponse.characterResponseToCharacterModel(): CharacterModel {
        return CharacterModel(
            name = name,
            url = image
        )
    }


}

