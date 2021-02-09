package com.example.androidjetpackcompose.util

interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(entity: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T
}