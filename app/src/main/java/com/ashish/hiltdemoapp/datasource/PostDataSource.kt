package com.ashish.hiltdemoapp.datasource

import com.ashish.hiltdemoapp.model.Posts
import com.ashish.hiltdemoapp.service.PostService
import javax.inject.Inject

class PostDataSource @Inject constructor(
        private val postService: PostService
) : DataSource {
    override suspend fun getPosts(): List<Posts> = postService.getPosts()
}