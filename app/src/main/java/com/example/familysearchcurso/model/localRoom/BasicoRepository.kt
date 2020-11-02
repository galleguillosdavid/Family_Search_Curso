package com.example.familysearchcurso.model.localRoom

import android.util.Log
import com.example.familysearchcurso.model.localRoom.NetworkRetrofit.RetrofitClient
import com.example.familysearchcurso.model.localRoom.NetworkRetrofit.pojo.Basico
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BasicoRepository (private val basicoDao: BasicoDao) {
    private val retroService = RetrofitClient.getRetrofitClient()
    val allBasicLiveData = basicoDao.ShowAllBasicosInDb()

    //la vieja confiable
    fun getDataFromNetwork() {
        val call = retroService.fetchAllFromNetwork()
        call.enqueue(object : Callback<List<Basico>> {
            override fun onResponse(call: Call<List<Basico>>, response: Response<List<Basico>>) {
                when (response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            basicoDao.InserAllBasicosInDb(converters(it))
                        }
                    }
                    in 300..599 -> Log.d("Response", response.body().toString())
                    else -> Log.d("Error", response.body().toString())
                }
            }

            override fun onFailure(call: Call<List<Basico>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
        })
    }

    fun converters(listFromNetwork: List<Basico>): List<BasicoEntity> {
        val listMutable = mutableListOf<BasicoEntity>()

        listFromNetwork.map {
            listMutable.add(
                    BasicoEntity(
                            it.id,
                            it.categoria,
                            it.dificultad,
                            it.duracion,
                            it.imagen,
                            it.nombre,
                            it.url
                    )
            )
        }
        return listMutable
    }
}