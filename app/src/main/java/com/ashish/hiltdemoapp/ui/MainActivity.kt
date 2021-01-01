package com.ashish.hiltdemoapp.ui

import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.observe
import com.ashish.hiltdemoapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    override val viewModel: MainActivityViewModel by viewModels()

    override fun onObserve() {
        viewModel.uiState().observe(this) {
            showPost(it)
        }
        viewModel.getPosts()
    }

    private fun showPost(postState: PostState) {
        when (postState) {
            is PostState.Loading -> {
                binding.progressBar.isVisible = true
            }
            is PostState.Success -> {
                binding.progressBar.isVisible = false
                Log.e("app", "Post data is-- ${postState.entries.first()}")
                binding.postText.text = postState.entries.first().toString()
            }
            is PostState.Error -> {
                binding.progressBar.isVisible = false
                Toast.makeText(this@MainActivity, postState.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}