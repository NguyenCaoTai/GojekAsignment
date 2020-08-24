package com.example.myapplication.ui.main.utilities

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.myapplication.bussiness.Mapper
import com.example.myapplication.bussiness.Repository
import com.example.myapplication.bussiness.RepositoryImpl
import com.example.myapplication.data.Service
import com.example.myapplication.ui.main.MainViewModelFactory

object InjectorUtils {
    private fun getRepository(
        service: Service,
        mapper: Mapper
    ): Repository = RepositoryImpl(service, mapper)

    fun provideMainViewModelFactory(
        application: Application,
        service: Service,
        mapper: Mapper
    ): MainViewModelFactory = MainViewModelFactory(
        application,
        getRepository(service, mapper)
    )
}