package com.ashish.hiltdemoapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.ashish.hiltdemoapp.databinding.ActivityLoginBinding
import com.ashish.hiltdemoapp.ui.BaseActivity
import com.ashish.hiltdemoapp.ui.mainactivity.PostListActivity

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    override fun onObserve() {

    }

    private fun initialize() {
        binding.signInButton.setOnClickListener {
            startActivity(Intent(this, PostListActivity::class.java))
        }
    }

    override fun getViewBinding(): ActivityLoginBinding =
        ActivityLoginBinding.inflate(layoutInflater)
}