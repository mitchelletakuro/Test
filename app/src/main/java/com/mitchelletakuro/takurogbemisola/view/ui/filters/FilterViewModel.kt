package com.mitchelletakuro.takurogbemisola.view.ui.filters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mitchelletakuro.takurogbemisola.data.models.FilterModel
import com.mitchelletakuro.takurogbemisola.data.repository.FilterRepo
import kotlinx.coroutines.launch
import java.lang.Exception


class FilterViewModel(private val filterRepo: FilterRepo) : ViewModel() {


//    this represents the data you will fetch, you can add more for the different types that this viewmodel will get
    private val _postList = MutableLiveData<List<FilterModel>>()
    val postList: LiveData<List<FilterModel>>
        get() = _postList



//     you can use this to display a Progress bar
    val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading


// you can use this for errors
    val _errors = MutableLiveData<String>()
    val error: LiveData<String> get() = _errors


    fun getPosts(){
        _loading.postValue(true)
        viewModelScope.launch {
            try {
                val posts = filterRepo.fetchPosts()
                _loading.postValue(false)
                _postList.postValue(posts)
            }catch (e:Exception){
                _errors.postValue(e.localizedMessage)
            }


        }
    }

}