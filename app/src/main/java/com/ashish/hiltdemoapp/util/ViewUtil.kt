package com.ashish.hiltdemoapp.util

import android.view.View
import androidx.core.content.ContextCompat
import com.ashish.hiltdemoapp.MyApp

class ViewUtil {
    fun View.show() {
        this.visibility = View.VISIBLE
    }

    fun View.hide() {
        this.visibility = View.INVISIBLE
    }

    fun View.remove() {
        this.visibility = View.GONE
    }

    fun Int.asColor() = ContextCompat.getColor(MyApp.instance, this)
    fun Int.asDrawable() = ContextCompat.getDrawable(MyApp.instance, this)
}