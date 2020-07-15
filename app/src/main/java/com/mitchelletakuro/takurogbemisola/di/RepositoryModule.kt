package com.mitchelletakuro.takurogbemisola.di

import com.mitchelletakuro.takurogbemisola.data.repository.FilterRepo
import org.koin.dsl.module


val repoModule = module {


//    Gbemisola,  you can add any other repository  here
//    i.e single { className(get())  }

     single { FilterRepo(get())  }
}