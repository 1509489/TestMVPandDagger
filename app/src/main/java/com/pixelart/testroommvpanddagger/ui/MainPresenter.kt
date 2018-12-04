package com.pixelart.testroommvpanddagger.ui

import com.pixelart.testroommvpanddagger.di.ApplicationComponent
import com.pixelart.testroommvpanddagger.di.DaggerApplicationComponent
import com.pixelart.testroommvpanddagger.di.NetworkModule
import com.pixelart.testroommvpanddagger.model.Posts
import com.pixelart.testroommvpanddagger.remote.APIService
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter(private val mainView: MainActivityContract.View): MainActivityContract.Presenter{

    @Inject
    lateinit var apiService: APIService

    private var subscription: Disposable? = null
    lateinit var applicationComponent: ApplicationComponent


    override fun getPost(posts: List<Posts>) {

    }

    override fun onStop() {
        subscription?.dispose()
    }

    override fun onResume() {


         /*DaggerApplicationComponent.builder()
            .networkModule(NetworkModule)
            .build()
            .getAPIService().getPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : SingleObserver<Posts>{
                override fun onSuccess(t: Posts) {
                    mainView.displayPost(t)
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            })*/
        subscription = apiService.getPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { posts -> mainView.showPost(posts)  },
                {mainView.showError("Error")}
            )
    }

}