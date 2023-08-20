package br.com.fundatecheroesti21.home.domain

import br.com.fundatecheroesti21.character.data.repository.CharacterRepository
import br.com.fundatecheroesti21.home.presentation.model.CharacterModel

class GetCharacterListUseCase {
    private val repository by lazy {
        CharacterRepository()
    }

    suspend fun listCharacter(): List<CharacterModel> {
        return repository.getPersonagem()
    }
}