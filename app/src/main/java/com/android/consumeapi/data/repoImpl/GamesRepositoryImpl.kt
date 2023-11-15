package com.android.consumeapi.data.repoImpl

import com.android.consumeapi.data.mapper.GamesMapper
import com.android.consumeapi.data.remote.GameService
import com.android.consumeapi.domain.model.GameItem
import com.android.consumeapi.domain.repo.GamesRepository
import com.android.consumeapi.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val gameService: GameService,
    private val gamesMapper: GamesMapper
    ): GamesRepository {

    override suspend fun getGames(): Flow<Resource<List<GameItem>>> {
        return flow{
            emit(Resource.Loading())
            val games = gameService.getGames()
            if (games.isNotEmpty()){
                val gameItems = gamesMapper.entityToModel(games)
                emit(Resource.Success(gameItems))
            }else{
                emit(Resource.Error("Something went wrong"))
            }
        }
    }
}
