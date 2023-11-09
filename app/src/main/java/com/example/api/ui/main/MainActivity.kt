package com.example.api.ui.main

import PostAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api.R
import com.example.api.databinding.ActivityMainBinding
import com.example.api.pojo.PostsModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PostViewModel
      private lateinit var adapter :PostAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        viewModel=ViewModelProviders.of(this).get(PostViewModel::class.java)
        viewModel.getPosts()
        adapter=PostAdapter(this)
        binding.recycler.adapter=adapter
        binding.recycler.layoutManager=LinearLayoutManager(this)
        viewModel.psostsMutableLiveData.observe(this, Observer {
            adapter.postList=it
            adapter.notifyDataSetChanged()
            
        })



    }
}