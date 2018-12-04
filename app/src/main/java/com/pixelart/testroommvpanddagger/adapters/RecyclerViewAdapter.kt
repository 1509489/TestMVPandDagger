package com.pixelart.testroommvpanddagger.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pixelart.testroommvpanddagger.R
import com.pixelart.testroommvpanddagger.databinding.RecyclerviewLayoutBinding
import com.pixelart.testroommvpanddagger.model.FavoriteCelebrity
import com.pixelart.testroommvpanddagger.model.Posts
import kotlinx.android.synthetic.main.recyclerview_layout.view.*

class RecyclerViewAdapter(val postsList: List<Posts>, val listener: RecyclerViewAdapter.OnItemClickedListener): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        context = viewGroup.context
        val binding: RecyclerviewLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.recyclerview_layout, viewGroup, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val post = postsList[position]
        holder.itemView.apply {
            tvPostTitle.text = post.title
            tvPostBody.text = post.body
        }

        holder.itemView.setOnClickListener {
            listener.onItemClicked(position)
        }
    }

    class ViewHolder(itemView: RecyclerviewLayoutBinding): RecyclerView.ViewHolder(itemView.root)

    interface OnItemClickedListener{
        fun onItemClicked(position: Int)
    }
}