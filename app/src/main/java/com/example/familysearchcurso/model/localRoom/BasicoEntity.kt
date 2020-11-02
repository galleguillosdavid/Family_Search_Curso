package com.example.familysearchcurso.model.localRoom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basic_table")
data class BasicoEntity (
    @PrimaryKey
    val id: Int,
    val categoria: String,
    val dificultad: Int,
    val duracion: String,
    val imagen: String,
    val nombre: String,
    val url: String

)