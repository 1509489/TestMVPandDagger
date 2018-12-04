package com.pixelart.testroommvpanddagger.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

abstract class BaseActivity<T : BasePresenter>: AppCompatActivity(), BaseView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    abstract fun init()
    abstract fun getViewPresenter():T
}