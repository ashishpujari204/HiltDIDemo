package com.ashish.hiltdemoapp.ui.mainactivity

import com.ashish.hiltdemoapp.model.Posts

sealed class PostState {
    object Loading : PostState()
    data class Success(val entries: List<Posts>) : PostState()
    data class Error(val message: String) : PostState()
}