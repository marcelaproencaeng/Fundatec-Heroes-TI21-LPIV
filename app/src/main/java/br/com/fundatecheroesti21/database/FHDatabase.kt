package br.com.fundatecheroesti21.database

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.fundatecheroesti21.App
import br.com.fundatecheroesti21.UserDao
import br.com.fundatecheroesti21.UserEntity

@Database(entities = [UserEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class FHDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(): FHDatabase {
            return Room.databaseBuilder(
                App.context,
                FHDatabase::class.java,
                "fh.database"
            ).allowMainThreadQueries().build()
        }
    }
}