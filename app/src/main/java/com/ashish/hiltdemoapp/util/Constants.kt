package com.ashish.hiltdemoapp.util

import android.app.Activity
import com.ashish.hiltdemoapp.storage.SharedPreferencesStorage
import javax.inject.Inject

class Constants {
    @Inject
    lateinit var sharedPreferencesStorage: SharedPreferencesStorage

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        const val PREFERENCE_NAME = "HiltDemo"
        const val TYPE = "type"

        fun getType(activity: Activity): String {
            return SharedPreferencesStorage(activity).getString(TYPE)
        }

        fun saveType(activity: Activity, type: String) {
            SharedPreferencesStorage(activity).setString(TYPE, type)
        }
    }
}