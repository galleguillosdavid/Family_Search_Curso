package com.example.familysearchcurso.model.localRoom.NetworkRetrofit.pojo


import com.google.gson.annotations.SerializedName

data class Medio(
    @SerializedName("categoria")
    val categoria: String,
    @SerializedName("dificultad")
    val dificultad: Int,
    @SerializedName("duracion")
    val duracion: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imagen")
    val imagen: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("url")
    val url: String
)