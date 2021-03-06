package com.example.jsonfile

import android.app.Application
import android.content.Context
import com.example.jsonfile.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JsonFileApp:Application() {

    override fun onCreate() {
        super.onCreate()

        context = applicationContext
        startKoin {
            androidContext(this@JsonFileApp)
            modules(appModules)
        }
    }

    companion object{
        private lateinit var context: Context
        fun applicationContext() = context
    }
}