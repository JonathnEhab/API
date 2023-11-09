package com.example.api.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.api.data.PostsClint
import com.example.api.pojo.PostsModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class PostViewModel:ViewModel() {

    lateinit var psostsMutableLiveData: MutableLiveData<List<PostsModel>>



    var posts = MutableLiveData<String>()
    fun getPosts(){
        psostsMutableLiveData=MutableLiveData()

        PostsClint.getInstance().getPosts().enqueue(object :retrofit2.Callback<List<PostsModel>>{
              override fun onResponse(
                  call: Call<List<PostsModel>>,
                  response: Response<List<PostsModel>>
              ) {
             psostsMutableLiveData.value=response.body()
              }

              override fun onFailure(call: Call<List<PostsModel>>, t: Throwable) {
                  posts.value="error"
              }

          })
    }
}