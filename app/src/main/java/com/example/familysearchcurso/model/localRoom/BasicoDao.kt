package com.example.familysearchcurso.model.localRoom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BasicoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun InserAllBasicosInDb(mList: List<BasicoEntity>)

    @Query("SELECT * FROM basic_table")
    fun ShowAllBasicosInDb(): LiveData<List<BasicoEntity>>

    @Query("SELECT * FROM basic_table WHERE id=:Mid")
    fun ShowOneBasicosInDb(Mid:Int): LiveData<BasicoEntity>

}