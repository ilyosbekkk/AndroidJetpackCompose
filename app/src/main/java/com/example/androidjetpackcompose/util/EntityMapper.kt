package com.example.androidjetpackcompose.util

interface EntityMapper<Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel
    fun toEntity(domainModel: DomainModel): Entity
}