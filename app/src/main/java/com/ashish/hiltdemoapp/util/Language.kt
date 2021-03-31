package com.ashish.hiltdemoapp.util

enum class Language {
    ENGLISH,
    MARATHI;

    fun toLocal(): String {
        return when (this) {
            ENGLISH -> "en"
            MARATHI -> "mr"
            else -> "en"
        }
    }

    fun getLocalLanguage(): String {
        return "en"
    }
}