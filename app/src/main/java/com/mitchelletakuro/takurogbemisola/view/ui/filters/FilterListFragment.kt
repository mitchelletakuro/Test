package com.mitchelletakuro.takurogbemisola.view.ui.filters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mitchelletakuro.takurogbemisola.R
import com.mitchelletakuro.takurogbemisola.data.models.CarOwner
import com.mitchelletakuro.takurogbemisola.data.models.FilterModel
import com.mitchelletakuro.takurogbemisola.view.ui.filters.adapters.OnItemClickListener
import kotlinx.android.synthetic.main.filter_list.*
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber
import com.mitchelletakuro.takurogbemisola.view.ui.filters.adapters.FilterAdapter as FilterAdapter


class FilterListFragment : Fragment() {

    private lateinit var filterRV: RecyclerView
    lateinit  var filters : List<FilterModel>
    lateinit var owners : List<CarOwner>



    private val viewModel: FilterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filter_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPosts()



        filter_list.layoutManager = LinearLayoutManager(activity)
        filter_list.setHasFixedSize(true)
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
                filterRV.adapter = FilterAdapter (it, object : OnItemClickListener {
                    override fun onItemClicked(clicked: FilterModel) {
                        findNavController().navigate(R.id.action_filterListFragment_to_carOwnerDetailsFragment,
                            bundleOf( "filter" to clicked , "owners" to owners))
                    }
                })
            }
        })


        viewModel.error.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
//            you can add your own method to display errors to the user
             Timber.e(it)
//            showCustomErrorResponse(it)
        })
    }
}