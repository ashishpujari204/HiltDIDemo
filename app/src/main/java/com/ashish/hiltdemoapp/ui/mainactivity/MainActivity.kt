package com.ashish.hiltdemoapp.ui.mainactivity

import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.observe
import com.ashish.hiltdemoapp.databinding.ActivityMainBinding
import com.ashish.hiltdemoapp.ui.BaseActivity
import com.ashish.hiltdemoapp.ui.mainactivity.PostState.Error
import com.ashish.hiltdemoapp.ui.mainactivity.PostState.Loading
import com.ashish.hiltdemoapp.ui.mainactivity.PostState.Success
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
            is Loading -> {
                binding.progressBar.isVisible = true
            }
            is Success -> {
                binding.progressBar.isVisible = false
                binding.postText.text = postState.entries.first().toString()
            }
            is Error -> {
                binding.progressBar.isVisible = false
                Toast.makeText(this@MainActivity, postState.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}