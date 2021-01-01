package com.ashish.hiltdemoapp.di

import android.content.Context
import com.ashish.hiltdemoapp.storage.SharedPreferencesStorage
import com.ashish.hiltdemoapp.storage.Storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class SharedPreferenceModule {
    @Provides
    @ActivityRetainedScoped
    fun provideSharedPreference(@ApplicationContext context: Context): Storage {
        return SharedPreferencesStorage(context)
    }
}