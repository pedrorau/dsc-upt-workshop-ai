package com.example.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.myapplication.data.source.EventDataSource
import com.example.myapplication.data.source.MockEventDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEventDataSource(): EventDataSource {
        return MockEventDataSource()
    }
}