package com.ashish.hiltdemoapp.di

import com.ashish.hiltdemoapp.BuildConfig
import com.ashish.hiltdemoapp.datasource.DataSource
import com.ashish.hiltdemoapp.datasource.PostDataSource
import com.ashish.hiltdemoapp.service.PostService
import com.ashish.hiltdemoapp.util.Constants.Companion.BASE_URL
import com.ashish.hiltdemoapp.util.Language
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePostService(retrofit: Retrofit): PostService = retrofit.create(
        PostService::class.java
    )

    @Provides
    @Singleton
    fun provideDataSource(postService: PostService):
            DataSource = PostDataSource(postService)

    private val interceptor: Interceptor
        get() = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
}