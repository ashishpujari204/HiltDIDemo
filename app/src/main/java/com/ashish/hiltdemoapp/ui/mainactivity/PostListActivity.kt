package com.ashish.hiltdemoapp.ui.mainactivity

import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.observe
import com.ashish.hiltdemoapp.databinding.ActivityMainBinding
import com.ashish.hiltdemoapp.model.Posts
import com.ashish.hiltdemoapp.ui.BaseActivity
import com.ashish.hiltdemoapp.ui.mainactivity.PostState.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostListActivity : BaseActivity<ActivityMainBinding, PostActivityViewModel>() {

    override val viewModel: PostActivityViewModel by viewModels()
    private lateinit var postAdapter: PostAdapter

    override fun onObserve() {
        viewModel.uiState().observe(this) {
            showPost(it)
        }
        viewModel.getPosts()
    }

    private fun showPost(postState: PostState) {
        when (postState) {
            is Loading -> {
                binding.progressBar.isVisible = true
            }
            is Success -> {
                binding.progressBar.isVisible = false
                postAdapter = PostAdapter(
                    postState.entries as ArrayList<Posts>
                ) { postItem: Posts -> onItemClickEvent(postItem) }
                binding.postList.adapter = postAdapter
            }
            is Error -> {
                binding.progressBar.isVisible = false
                showErrorDialog(postState.message)
            }
        }
    }

    private fun onItemClickEvent(postData: Posts) {
        showToast(postData.title)
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}