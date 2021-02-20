package com.example.androidjetpackcompose.dependecy_injections

import com.example.androidjetpackcompose.domain.model.RecipeDtoMapper
import com.example.androidjetpackcompose.network.model.RecipeService
import com.example.androidjetpackcompose.repository.RecipeRepository
import com.example.androidjetpackcompose.repository.RecipeRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImplementation(recipeService, recipeDtoMapper)
    }
}