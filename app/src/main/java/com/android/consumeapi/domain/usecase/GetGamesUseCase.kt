package com.android.consumeapi.domain.usecase

import com.android.consumeapi.domain.repo.GamesRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val gamesRepository: GamesRepository) {
    suspend fun getGames() = gamesRepository.getGames()
}
