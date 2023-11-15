package com.android.consumeapi.data.remote

import com.android.consumeapi.data.model.GameModel
import javax.inject.Inject

class GameService @Inject constructor(private val gamesApi: GamesApi) {

    suspend fun getGames(): List<GameModel>{
        val games = gamesApi.getGames()
        return games.body()?: emptyList()
    }
}
