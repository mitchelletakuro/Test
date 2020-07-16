package com.mitchelletakuro.takurogbemisola.di

import com.mitchelletakuro.takurogbemisola.view.ui.car_owners.CarOwnerViewModel
import com.mitchelletakuro.takurogbemisola.view.ui.filters.FilterViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel


val viewModelModule = module {

    viewModel {
        FilterViewModel(get())
    }

//    viewModel {
//        CarOwnerViewModel(get())
//    }






}