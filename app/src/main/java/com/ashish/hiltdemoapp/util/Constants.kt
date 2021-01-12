package com.ashish.hiltdemoapp.util

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.ashish.hiltdemoapp.storage.SharedPreferencesStorage
import javax.inject.Inject

class Constants {
    @Inject
    lateinit var sharedPreferencesStorage: SharedPreferencesStorage

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        const val PREFERENCE_NAME = "HiltDemo"
        private const val TYPE = "type"

        fun getType(activity: Activity): String {
            return SharedPreferencesStorage(activity).getString(TYPE)
        }

        fun saveType(activity: Activity, type: String) {
            SharedPreferencesStorage(activity).setString(TYPE, type)
        }

        /**
         * Application minSdkVersion is 23
         */
        fun isInternetAvailable(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
    }
}