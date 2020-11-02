package com.example.familysearchcurso.model.localRoom.NetworkRetrofit

import com.example.familysearchcurso.model.localRoom.NetworkRetrofit.pojo.Basico
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface CursoApi {

//Vieja confiable
@GET ("db.json/")
fun fetchAllFromNetwork():Call<List<Basico>>

@GET("db.json/")
fun fetchAllFromNetworkRF():Response<List<Basico>>
}
