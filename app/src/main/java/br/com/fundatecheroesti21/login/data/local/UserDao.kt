package br.com.fundatecheroesti21.login.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fundatecheroesti21.UserEntity
import java.util.*

@Dao
interface UserDao {
//  @Insert
//    fun insertUser(userEntity: UserEntity)
//
//    @Query("SELECT * from  userTable")
//    fun getUser(): List<UserEntity>
//
//    @Query("SELECT date from userTable")
//    fun getUserDate(): Date?
//
//    @Query("DELETE from userTable")
//    fun clearCache()
//}
    @Insert
    fun insertUser(userEntity: UserEntity)

    @Query("SELECT * from  userTable")
    fun getUser(): List<UserEntity>

//    @Query("SELECT * from userTable")
//    fun getUserId(): List<UserEntity>

//    @Query("SELECT dataLog FROM userTable")
//    fun getCache(): Date

//    @Query("DELETE dataLog FROM userTable ")
//    fun deletarCache()

    @Query("SELECT date from userTable)")
    fun getUserDate(): Date?

    @Query("DELETE from userTable")
    fun clearCache()


}