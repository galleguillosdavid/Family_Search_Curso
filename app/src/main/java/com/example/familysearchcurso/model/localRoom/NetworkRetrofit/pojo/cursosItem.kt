package com.example.familysearchcurso.model.localRoom.NetworkRetrofit.pojo


import com.google.gson.annotations.SerializedName

data class cursosItem(
    @SerializedName("basico")
    val basico: List<Basico>,
    @SerializedName("medio")
    val medio: List<Medio>
)