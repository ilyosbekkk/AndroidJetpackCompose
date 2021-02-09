package com.example.androidjetpackcompose.repository

import com.example.androidjetpackcompose.domain.model.Recipe
import com.example.androidjetpackcompose.domain.model.RecipeDtoMapper
import com.example.androidjetpackcompose.network.model.RecipeService

class RecipeRepositoryImplementation(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
) : RecipeRepository {


    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        val result = recipeService.search(token, page, query).recipes
        return mapper.toDomainList(result)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        val result = recipeService.get(token, id)
        return mapper.mapToDomainModel(result)
    }

}