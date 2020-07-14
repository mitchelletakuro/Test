package com.mitchelletakuro.takurogbemisola.di

import com.mitchelletakuro.takurogbemisola.view.ui.filters.FilterViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

/**
 * Created by manuelchris-ogar on 14/07/2020.
 */
val viewModelModule = module {

    viewModel {
        FilterViewModel(get(), androidApplication())
    }


//     you can add other view models by adding new scopes,
//    add get() to cover any dependency
//    viewModel {
//        AnotherViewModel(get())
//    }





}