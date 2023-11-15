package com.android.consumeapi.data.remote

import com.android.consumeapi.data.model.GameModel
import com.android.consumeapi.util.Constant.Companion.GAMES_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface GamesApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>
}
