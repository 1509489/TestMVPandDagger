package com.pixelart.testroommvpanddagger.di

import com.pixelart.testroommvpanddagger.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent{



    fun inject(mainActivity: MainActivity)

}