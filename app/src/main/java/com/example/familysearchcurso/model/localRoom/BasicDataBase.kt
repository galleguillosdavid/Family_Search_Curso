package com.example.familysearchcurso.model.localRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BasicoEntity::class], version = 1)
//@TypeConverters(TypeConverterListoToString::class)

abstract class BasicDataBase : RoomDatabase() {
    abstract fun basicDao(): BasicoDao


    companion object {
        @Volatile
        private var INSTANCE : BasicDataBase?= null
        fun getDatabase(context: Context): BasicDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                    BasicDataBase::class.java,
                    "basic_db")
                    .build()
                 INSTANCE= instance
                return instance
            }
        }

    }
}