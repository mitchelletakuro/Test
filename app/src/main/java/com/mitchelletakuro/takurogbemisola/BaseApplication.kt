package com.mitchelletakuro.takurogbemisola

import android.app.Application
import com.mitchelletakuro.takurogbemisola.di.appComponent
import com.mitchelletakuro.takurogbemisola.di.repoModule
import com.mitchelletakuro.takurogbemisola.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            androidLogger()
            modules(listOf(appComponent, repoModule, viewModelModule))
        }
    }
}
