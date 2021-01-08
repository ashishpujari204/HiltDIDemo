package com.ashish.hiltdemoapp.ui.mainactivity

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.ashish.hiltdemoapp.repository.PostsRepository
import com.ashish.hiltdemoapp.ui.mainactivity.PostState.Error
import com.ashish.hiltdemoapp.ui.mainactivity.PostState.Loading
import com.ashish.hiltdemoapp.ui.mainactivity.PostState.Success
import com.ashish.hiltdemoapp.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

class PostActivityViewModel @ViewModelInject constructor(
    private val postsRepository: PostsRepository
) : BaseViewModel<PostState>() {
    fun getPosts() {
        uiState.value = Loading
        viewModelScope.launch {
            try {
                uiState.value = Success(postsRepository.getPosts())
            } catch (exception: Exception) {
                uiState.value = Error("Error retrieving post")
            }
        }
    }
}