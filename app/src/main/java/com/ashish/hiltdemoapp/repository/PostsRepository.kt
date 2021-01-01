package com.ashish.hiltdemoapp.repository

import com.ashish.hiltdemoapp.model.Posts
import com.ashish.hiltdemoapp.datasource.DataSource
import javax.inject.Inject

class PostsRepository @Inject constructor(private val dataSource: DataSource) : Repository {
    override suspend fun getPosts(): List<Posts> = dataSource.getPosts()
}