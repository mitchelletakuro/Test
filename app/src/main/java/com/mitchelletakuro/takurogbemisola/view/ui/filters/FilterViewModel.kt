package com.mitchelletakuro.takurogbemisola.view.ui.filters

import android.app.Application
import androidx.lifecycle.*
import com.google.gson.Gson
import com.mitchelletakuro.takurogbemisola.R
import com.mitchelletakuro.takurogbemisola.data.models.Filter
import com.mitchelletakuro.takurogbemisola.data.models.PostsModel
import com.mitchelletakuro.takurogbemisola.data.repository.FilterRepo
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * Created by manuelchris-ogar on 14/07/2020.
 */
class FilterViewModel(private val filterRepo: FilterRepo, application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext


//    this represents the data you will fetch, you can add more for the different types that this viewmodel will get
    private val _postList = MutableLiveData<List<PostsModel>>()
    val postList: LiveData<List<PostsModel>>
        get() = _postList

    private val _fiterList = MutableLiveData<List<Filter>>()
    val fiterList: LiveData<List<Filter>>
        get() = _fiterList

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

    fun getJson(){
        _loading.postValue(true)
        viewModelScope.launch {
            try {
                val text = context.resources.openRawResource(R.raw.filter).bufferedReader().use { it.readText() }
                val gson = Gson()
                val filterModel: Array<Filter> = gson.fromJson<Array<Filter>>(text, Array<Filter>::class.java)
                _loading.postValue(false)
                _fiterList.postValue(filterModel.toList())
            }catch (e:Exception){
                _errors.postValue(e.localizedMessage)
            }


        }
    }

}