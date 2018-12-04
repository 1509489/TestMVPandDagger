package com.pixelart.testroommvpanddagger.di

import com.pixelart.testroommvpanddagger.base.BaseView
import com.pixelart.testroommvpanddagger.remote.APIService
import com.pixelart.testroommvpanddagger.ui.MainActivity
import com.pixelart.testroommvpanddagger.ui.MainActivityContract
import com.pixelart.testroommvpanddagger.ui.MainPresenter
import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent{

    fun getRetrofit(): Retrofit
    fun getOkHttpClient(): OkHttpClient
    fun getAPIService(): APIService

    fun inject(mainActivity: MainActivity)
    fun postInject(mainPresenter: MainActivityContract.Presenter)

}