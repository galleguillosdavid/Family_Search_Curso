package com.example.familysearchcurso.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.familysearchcurso.model.localRoom.BasicDataBase
import com.example.familysearchcurso.model.localRoom.BasicoEntity
import com.example.familysearchcurso.model.localRoom.BasicoRepository

class BasicoViewModel(application: Application): AndroidViewModel(application) {

    private val mRepository: BasicoRepository
    val liveDataFromLocal: LiveData<List<BasicoEntity>>

    init {
        val basicoDao= BasicDataBase.getDatabase(application).basicDao()
        mRepository= BasicoRepository(basicoDao)
        mRepository.getDataFromNetwork()
        liveDataFromLocal= mRepository.allBasicLiveData
    }

}