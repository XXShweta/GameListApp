package com.android.consumeapi.data.mapper

interface EntityMapper<Entity, DomainModel> {
    fun entityToModel(entity: Entity): DomainModel
}
