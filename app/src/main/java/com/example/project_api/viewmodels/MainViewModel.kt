package com.example.project_api.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.project_api.models.bebida
import com.example.project_api.repositories.DrinkRepository
import com.example.project_api.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel  @ViewModelInject constructor(private val drinkRepository: DrinkRepository) : ViewModel() {
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
                emit(drinkRepository.getBebidaList(nombreBebida))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

    fun savebebida(Bebida: bebida) {
        viewModelScope.launch {
            drinkRepository.SaveBebida(Bebida)
        }
    }

    fun getBebidaFav() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(drinkRepository.getFavBebidad())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}
