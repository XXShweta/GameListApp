package com.android.consumeapi.domain.repo

import com.android.consumeapi.domain.model.GameItem
import com.android.consumeapi.util.Resource
import kotlinx.coroutines.flow.Flow

interface GamesRepository {

    suspend fun getGames(): Flow<Resource<List<GameItem>>>
}
