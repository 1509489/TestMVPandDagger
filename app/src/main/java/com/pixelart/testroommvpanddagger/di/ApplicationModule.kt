package com.pixelart.testroommvpanddagger.di

import android.app.Activity
import android.databinding.DataBindingUtil
import com.pixelart.testroommvpanddagger.R
import com.pixelart.testroommvpanddagger.base.BaseActivity
import com.pixelart.testroommvpanddagger.databinding.ActivityMainBinding
import com.pixelart.testroommvpanddagger.ui.MainActivity
import com.pixelart.testroommvpanddagger.ui.MainActivityContract
import com.pixelart.testroommvpanddagger.ui.MainPresenter
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class ApplicationModule(private val baseActivity: BaseActivity<*>){

    @Provides
    fun providesMainContractPresenter():MainActivityContract.Presenter = MainPresenter(baseActivity as MainActivity)

    @Provides
    fun providesMainActivityBinding():ActivityMainBinding = DataBindingUtil.setContentView(baseActivity as Activity, R.layout.activity_main)
}