package com.example.project_api.ui.VM

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.project_api.data.model.bebida
import com.example.project_api.domain.Repositorio
import com.example.project_api.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainVM @ViewModelInject constructor(private val repositorio: Repositorio) : ViewModel() {
    private val bebidaData = MutableLiveData<String>()
    fun setBebida(bebidaName: String) {
        bebidaData.value = bebidaName
    }

    init {
        setBebida("Cocktail")
    }

    val fetchBebidaList = bebidaData.distinctUntilChanged().switchMap { nombreBebida ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repositorio.getBebidaList(nombreBebida))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

    fun savebebida(Bebida: bebida) {
        viewModelScope.launch {
            repositorio.SaveBebida(Bebida)
        }
    }

    fun getBebidaFav() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repositorio.getFavBebidad())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}
