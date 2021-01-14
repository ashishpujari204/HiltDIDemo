package com.ashish.hiltdemoapp.ui

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.ashish.hiltdemoapp.R

abstract class BaseActivity<B : ViewBinding, VM : ViewModel> : AppCompatActivity() {

    lateinit var binding: B
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        onObserve()
        /**
         * To Prevent from tap jacking
         */
        binding.root.filterTouchesWhenObscured = true
    }

    abstract fun onObserve()

    abstract fun getViewBinding(): B

    private fun showAlertDialog(dialogBuilder: AlertDialog.Builder.() -> Unit) {
        val builder = AlertDialog.Builder(this)
        builder.dialogBuilder()
        val dialog = builder.create()
        dialog.show()
    }

    fun showErrorDialog(message: String) {
        showAlertDialog {
            setTitle(R.string.app_name)
            setMessage(message)
            positiveButton(getString(R.string.okay_text)) {
                finish()
            }
            negativeButton {}
        }
    }

    private fun AlertDialog.Builder.positiveButton(
        text: String = getString(R.string.okay_text),
        handleClick: (which: Int) -> Unit = {}
    ) {
        this.setPositiveButton(text) { _, which -> handleClick(which) }
    }

    private fun AlertDialog.Builder.negativeButton(
        text: String = getString(R.string.cancel_text),
        handleClick: (which: Int) -> Unit = {}
    ) {
        this.setNegativeButton(text) { _, which -> handleClick(which) }
    }

    fun showToast(message: String) {
        Toast.makeText(this@BaseActivity, message, Toast.LENGTH_LONG).show()
    }
}
