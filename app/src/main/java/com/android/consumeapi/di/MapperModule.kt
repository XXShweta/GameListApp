package com.android.consumeapi.di

import com.android.consumeapi.data.mapper.GamesMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideGamesMapper() = GamesMapper()

}
