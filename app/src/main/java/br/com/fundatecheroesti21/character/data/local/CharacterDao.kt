package br.com.fundatecheroesti21.character.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
class CharacterDao {
    @Insert
    fun insertCharacter(characterEntity: CharacterEntity)

    @Query("SELECT * FROM characterTable")
    fun getCharacter(): List<CharacterEntity>
}