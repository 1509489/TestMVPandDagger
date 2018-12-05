package com.pixelart.testroommvpanddagger.di

import com.pixelart.testroommvpanddagger.common.BASE_URL
import com.pixelart.testroommvpanddagger.remote.APIService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule{

    @Provides
    fun providesRetrofit(client: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesOkHttpClient():OkHttpClient{
        val intercepter = HttpLoggingInterceptor()
        intercepter.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder()
            .addInterceptor(intercepter)
            .build()

    }

    @Provides
    fun providesAPIService(retrofit: Retrofit):APIService = retrofit.create(APIService::class.java)
}