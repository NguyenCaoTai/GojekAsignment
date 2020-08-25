package com.example.myapplication.ui.main.utilities

import android.app.Application
import com.example.myapplication.bussiness.*
import com.example.myapplication.bussiness.model.User
import com.example.myapplication.data.Service
import com.example.myapplication.data.ServiceFactory
import com.example.myapplication.data.local.AppDatabase
import com.example.myapplication.ui.favoriteuser.FavoriteViewModelFactory
import com.example.myapplication.ui.main.MainViewModelFactory

object InjectorUtils {
    fun provideMainViewModelFactory(application: Application): MainViewModelFactory =
        MainViewModelFactory(
            application,
            getRepository(application)
        )

    fun provideFavoriteViewModelFactory(application: Application): FavoriteViewModelFactory =
        FavoriteViewModelFactory(
            application,
            getRepository(application)
        )

    private fun getDB(application: Application): AppDatabase =
        AppDatabase.getInstance(application)

    private fun getService(): Service =
        ServiceFactory.getService()

    private fun getUserMapper(): Mapper<String, User> =
        RandomUserMapper()

    private fun getBusinessToDaoUserMapper(): Mapper<User, com.example.myapplication.data.local.model.User> =
        BusinessUserToDaoMapper()

    private fun getDaoToBusinessUserMapper(): Mapper<com.example.myapplication.data.local.model.User, User> =
        DaoToBusinessUserMapper()

    private fun getRepository(application: Application): Repository =
        RepositoryImpl(
            service = getService(),
            dao = getDB(application).userDao(),
            randomUserMapper = getUserMapper(),
            businessUserToDaoMapper = getBusinessToDaoUserMapper(),
            daoToBusinessUserMapper = getDaoToBusinessUserMapper()
        )
}