package com.pixelart.testroommvpanddagger.base

interface BaseView{
    fun showMessage(message: String)
    fun showError(error: String)
}