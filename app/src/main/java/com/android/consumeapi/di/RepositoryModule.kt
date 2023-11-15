package com.android.consumeapi.di

import com.android.consumeapi.data.repoImpl.GamesRepositoryImpl
import com.android.consumeapi.domain.repo.GamesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGameRepository(gamesRepositoryImpl: GamesRepositoryImpl): GamesRepository = gamesRepositoryImpl

}
