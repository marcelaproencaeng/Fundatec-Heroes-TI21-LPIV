package br.com.fundatecheroesti21.login.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface UserDao {

    @Insert
    fun insertUser(userEntity: UserEntity)

    @Query("SELECT * from  userTable")
    fun getUser(): List<UserEntity>

    @Query("SELECT dataLog FROM userTable")
    fun getUserDate(): Date?

    @Query("DELETE from userTable")
    fun clearCache()

    //    @Query("SELECT dataLog FROM userTable")
    //    fun getCache(): Date?
    @Query("SELECT id FROM userTable")
    fun getId(): Int
//
//    @Query("DELETE from userTable")
//    fun deletarCache()


}