package com.mrmansur.singleactivityapplication.network

import com.mrmansur.singleactivityapplication.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    fun allPosts() : Call<ArrayList<Post>>
}