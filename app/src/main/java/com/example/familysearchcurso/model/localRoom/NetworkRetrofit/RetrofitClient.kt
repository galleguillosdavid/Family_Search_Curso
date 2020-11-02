package com.example.familysearchcurso.model.localRoom.NetworkRetrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private const val URL_BASE = "https://my-json-server.typicode.com/galleguillosdavid/Family_Search_Curso/"

        fun getRetrofitClient():BasicoApi{
            val mRetrofit= Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(BasicoApi::class.java)
        }
    }
}