package com.mitchelletakuro.takurogbemisola.di

import com.mitchelletakuro.takurogbemisola.data.repository.FilterRepo
import org.koin.dsl.module

/**
 * Created by manuelchris-ogar on 14/07/2020.
 */
val repoModule = module {


//    Gbemisola,  you can add any other repository  here
//    i.e single { className(get())  }

     single { FilterRepo(get())  }
}