package com.kseyko.mvvmroomdagger.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kseyko.mvvmroomdagger.data.model.MoneyModel
import com.kseyko.mvvmroomdagger.data.repository.MoneyRepository
import com.kseyko.mvvmroomdagger.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel   // ViewModelInject is Deprecated  = > Use HiltViewModel.
class HomeViewModel @Inject constructor(private val moneyRepository: MoneyRepository) :
    ViewModel() {


    val getMoneyFromApi: LiveData<Resource<List<MoneyModel>>> = fetchMoneyFromApi()
    val getMoneyFromDb: LiveData<List<MoneyModel>> = fetchMoneyFromDb()

    init {
        fetchMoneyFromApi()
        fetchMoneyFromDb()
    }

    private fun fetchMoneyFromDb(): LiveData<List<MoneyModel>> =
        moneyRepository.fetchMoneyFromDb().asLiveData()

    private fun fetchMoneyFromApi(): LiveData<Resource<List<MoneyModel>>> =
        moneyRepository.fetchMoneyFromApi().asLiveData()

    fun refreshdata() {
        fetchMoneyFromApi()
    }


}