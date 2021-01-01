package com.ashish.hiltdemoapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.ashish.hiltdemoapp.model.Posts
import com.ashish.hiltdemoapp.repository.PostsRepository
import com.ashish.hiltdemoapp.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class MainActivityViewModel @ViewModelInject constructor(private val postsRepository: PostsRepository) :
    BaseViewModel<PostState>() {
    fun getPosts() {
        uiState.value = PostState.Loading
        viewModelScope.launch {
            try {
                uiState.value = PostState.Success(postsRepository.getPosts())
            } catch (exception: Exception) {
                uiState.value = PostState.Error("Error retrieving post")
            }
        }
    }
}

sealed class PostState {
    object Loading : PostState()
    data class Success(val entries: List<Posts>) : PostState()
    data class Error(val message: String) : PostState()
}