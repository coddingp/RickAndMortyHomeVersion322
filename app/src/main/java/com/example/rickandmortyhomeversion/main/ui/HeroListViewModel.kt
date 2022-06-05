package com.example.rickandmortyhomeversion.main.ui

import android.util.Log
import androidx.lifecycle.*
import com.example.rickandmortyhomeversion.main.interactor.Interactor
import com.example.rickandmortyhomeversion.main.models.ResultParced
import kotlinx.coroutines.launch

class HeroListViewModel(
    private val interactor: Interactor
) : ViewModel() {
    val liveData = MutableLiveData<List<ResultParced>>()

    init {
        viewModelScope.launch {
            interactor.getDataFromDb().collect { list ->
                liveData.value = list
            }
        }
    }

    fun loadCharacters() = viewModelScope.launch {
        try {
            interactor.uploadHeroes()
        } catch (throwable: Throwable) {
            Log.e("###", "Error process in loadDataHeroes() ", throwable)
        }
    }
}




/*(
    private val interactor: Interactor
) : ViewModel() {


    val liveData: MutableLiveData<List<ResultParced>> by lazy {
        MutableLiveData<List<ResultParced>>().also {
            loadCharacters()
        }
    }

    init {
        viewModelScope.launch {
            interactor.getDataFromDb().collect() { list->
                liveData.value = list
            }
        }
    }

    fun loadCharacters() =
        viewModelScope.launch {
            interactor.uploadHeroes()
        }
        // Do an asynchronous operation to fetch characters.


}
*/