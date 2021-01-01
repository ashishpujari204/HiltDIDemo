package com.ashish.hiltdemoapp.repository

import com.ashish.hiltdemoapp.model.Posts

interface Repository {
    suspend fun getPosts(): List<Posts>
}