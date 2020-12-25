package com.example.jsonfile.di


import androidx.lifecycle.ViewModel
import com.example.jsonfile.ui.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { MainViewModel(androidApplication()) }
}

val appModules = listOf(viewModelModule)
