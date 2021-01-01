package com.ashish.hiltdemoapp.service

import com.ashish.hiltdemoapp.model.Posts
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    suspend fun getPosts(): List<Posts>
}