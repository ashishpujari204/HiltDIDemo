package com.ashish.hiltdemoapp.datasource

import com.ashish.hiltdemoapp.model.Posts


interface DataSource {
    suspend fun getPosts(): List<Posts>
}