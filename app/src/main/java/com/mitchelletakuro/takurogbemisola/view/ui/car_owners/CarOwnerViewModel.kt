package com.mitchelletakuro.takurogbemisola.view.ui.car_owners

import android.app.Application
import androidx.lifecycle.*
import com.mitchelletakuro.takurogbemisola.data.models.CarOwner
import com.mitchelletakuro.takurogbemisola.data.models.FilterModel
import com.mitchelletakuro.takurogbemisola.utils.filterCarOwners
import com.mitchelletakuro.takurogbemisola.utils.readDataFromRaw
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class CarOwnerViewModel (application: Application, private val Filter:FilterModel) :
AndroidViewModel(application) {

    private var job: Job? = null
    private var carOwners = ArrayList<CarOwner>()

    private val _carOwnersList = MutableLiveData<List<CarOwner>>()
    val carOwnersList: LiveData<List<CarOwner>>
        get() = _carOwnersList

    private var _showSnackbarEvent = MutableLiveData<Boolean?>()
    val showSnackBarEvent: LiveData<Boolean?>
        get() = _showSnackbarEvent


    init {
        job = viewModelScope.launch {
            getCarOwners()
        }
    }

    suspend fun getCarOwners() {
        withContext(Dispatchers.IO) {
            try {
                carOwners = readDataFromRaw()
                _carOwnersList.postValue(filterCarOwners(Filter , carOwners))
            } catch (e: IOException) {
                _carOwnersList.postValue(listOf())
                _showSnackbarEvent.postValue(true)
            }
        }
    }

    fun doneShowingSnackbar() {
        _showSnackbarEvent.value = null
    }



@Suppress("UNCHECKED_CAST")
class CarOwnerViewModelFactory(private val application: Application, private val filter: FilterModel) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            (CarOwnerViewModel(application, filter) as T)
}
}
