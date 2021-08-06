package com.techethic.compose.breastfeedingassistant

import android.app.Application
import com.techethic.compose.breastfeedingassistant.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application(){

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidContext(this@Application)
            modules(appModule)
        }
    }
}