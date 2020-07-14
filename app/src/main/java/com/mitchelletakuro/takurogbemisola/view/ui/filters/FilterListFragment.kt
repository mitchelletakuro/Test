package com.mitchelletakuro.takurogbemisola.view.ui.filters

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.mitchelletakuro.takurogbemisola.R
import com.mitchelletakuro.takurogbemisola.data.repository.FilterRepo
import com.mitchelletakuro.takurogbemisola.di.repoModule
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FilterListFragment : Fragment() {

    val viewModel: FilterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.filter_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        call to fetch data
//        viewModel.getFilter()

        viewModel.getPosts()

        setUpObservers()

    }

    private fun setUpObservers() {
        viewModel.loading.observe(viewLifecycleOwner, Observer{
//
            when(it){
                true ->{
                    // you can show a progress bar, loading would have started
                }
                false ->{
                    // you can hide a progress bar, loading should be done here
                }
            }
        })


        viewModel.postList.observe(viewLifecycleOwner, Observer{
            it?.let {
                Timber.e(it[0].toString())
//                show/display the list as you deem fit
            }
        })


        viewModel.error.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
//            you can add your own method to display errors to the user
             Timber.e(it)
//            showCustomErrorResponse(it)
        })
    }
}