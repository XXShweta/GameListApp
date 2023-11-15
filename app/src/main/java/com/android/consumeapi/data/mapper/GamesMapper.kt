package com.android.consumeapi.data.mapper

import com.android.consumeapi.data.model.GameModel
import com.android.consumeapi.domain.model.GameItem


class GamesMapper: EntityMapper<List<GameModel>, List<GameItem>> {
    override fun entityToModel(entity: List<GameModel>): List<GameItem> {
        return entity.map {
            it.toGameItem()
        }
    }

    private fun GameModel.toGameItem() = GameItem(id, title, thumbnail, short_description)
}
