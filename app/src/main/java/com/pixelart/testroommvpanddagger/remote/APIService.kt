package com.pixelart.testroommvpanddagger.remote

import com.pixelart.testroommvpanddagger.model.Posts
import io.reactivex.Observer
import io.reactivex.Single
import retrofit2.http.GET

interface APIService{
   /* @GET("posts")
    fun getPosts(): Single<Posts>*/

    @GET("posts")
    fun getPosts(): Single<List<Posts>>
}