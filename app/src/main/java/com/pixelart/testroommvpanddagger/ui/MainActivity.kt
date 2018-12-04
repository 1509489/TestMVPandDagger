package com.pixelart.testroommvpanddagger.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.pixelart.testroommvpanddagger.adapters.RecyclerViewAdapter
import com.pixelart.testroommvpanddagger.base.BaseActivity
import com.pixelart.testroommvpanddagger.databinding.ActivityMainBinding
import com.pixelart.testroommvpanddagger.di.ApplicationModule
import com.pixelart.testroommvpanddagger.di.DaggerApplicationComponent
import com.pixelart.testroommvpanddagger.di.NetworkModule
import com.pixelart.testroommvpanddagger.model.Posts
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityContract.Presenter>(), MainActivityContract.View, RecyclerViewAdapter.OnItemClickedListener {



    @Inject
    lateinit var presenter: MainActivityContract.Presenter
    @Inject
    lateinit var mainBinding: ActivityMainBinding

    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: RecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutManager = LinearLayoutManager(this)
    }

    override fun init() {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .networkModule(NetworkModule)
            .build()
            .inject(this)

/*
        DaggerApplicationComponent.builder()
            .networkModule(NetworkModule)
            .build().getOkHttpClient()

        DaggerApplicationComponent.builder()
            .networkModule(NetworkModule)
            .build().getRetrofit()*/
    }

    override fun showPost(posts: List<Posts>) {
        adapter = RecyclerViewAdapter(posts, this)
        mainBinding.recyclerView.adapter = adapter

    }

    override fun displayPost(post: Posts) {

    }

    override fun getViewPresenter(): MainActivityContract.Presenter = presenter

    override fun showError(error: String) {

    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onItemClicked(position: Int) {
        Toast.makeText(this, "Clicked position: $position", Toast.LENGTH_SHORT).show()
    }
}
