package br.com.fundatecheroesti21

import androidx.room.Room
import androidx.room.RoomDatabase

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