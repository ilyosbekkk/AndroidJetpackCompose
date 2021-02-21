package com.example.androidjetpackcompose.repository

import android.util.Log
import com.example.androidjetpackcompose.domain.model.Recipe
import com.example.androidjetpackcompose.domain.model.RecipeDtoMapper
import com.example.androidjetpackcompose.network.model.RecipeService
import com.example.androidjetpackcompose.util.TAG

class RecipeRepositoryImplementation(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
) : RecipeRepository {


    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token, page, query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token = token, id =id))
    }

}