package com.ashish.hiltdemoapp.di

import com.ashish.hiltdemoapp.repository.Repository
import com.ashish.hiltdemoapp.repository.PostsRepository
import com.ashish.hiltdemoapp.datasource.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class RepositoryModule {
    @Provides
    @ActivityRetainedScoped
    fun provideRepository(dataSource: DataSource): Repository {
        return PostsRepository(dataSource)
    }
}