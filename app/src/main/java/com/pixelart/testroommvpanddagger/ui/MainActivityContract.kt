package com.pixelart.testroommvpanddagger.ui

import com.pixelart.testroommvpanddagger.base.BasePresenter
import com.pixelart.testroommvpanddagger.base.BaseView
import com.pixelart.testroommvpanddagger.model.Posts

interface MainActivityContract{
    interface View: BaseView{
        fun showPost(posts: List<Posts>)
        fun displayPost(post: Posts)
    }

    interface Presenter: BasePresenter{
        fun getPost(posts: List<Posts>)
    }
}