package com.example.api.data

import com.example.api.pojo.PostsModel
import retrofit2.Call
import retrofit2.http.GET

interface PostInterFace {
    @GET("posts")
    fun getPosts():Call<List<PostsModel>>
}