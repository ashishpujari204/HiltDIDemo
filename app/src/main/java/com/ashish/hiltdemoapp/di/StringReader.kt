package com.ashish.hiltdemoapp.di

import android.content.Context
import androidx.annotation.StringRes
import com.ashish.hiltdemoapp.util.Language
import java.util.*
import javax.inject.Inject

class StringReader @Inject constructor(
    private val context: Context,
    private val language: Language
) {

    fun getString(@StringRes resId: Int): String {
        val config = context.resources.configuration
        config.setLocale(Locale(language.toLocal()))
        return context.createConfigurationContext(config).getText(resId).toString()
    }
}