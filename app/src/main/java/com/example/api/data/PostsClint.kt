package com.example.api.data

import com.example.api.pojo.PostsModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


 class PostsClint {
    private  val BASE_URL:String="https://jsonplaceholder.typicode.com/"
    private  var postInterFace:PostInterFace
    constructor(){
        var retrofit:Retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
        postInterFace=retrofit.create(PostInterFace::class.java)

    }

companion object{
    private var Instantce:PostsClint ?=null

     fun getInstance() :PostsClint{
     if (Instantce ==null){
           Instantce= PostsClint()
     }
        return Instantce as PostsClint
    }
}








    fun getPosts():Call<List<PostsModel>>{
        return postInterFace.getPosts()
    }







    }
