package com.example.androidjetpackcompose.domain.model

import android.util.Log
import com.example.androidjetpackcompose.network.model.model.RecipeDto
import com.example.androidjetpackcompose.util.DomainMapper
import com.example.androidjetpackcompose.util.TAG

class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(entity: RecipeDto): Recipe {
        return Recipe(
            id = entity.pk,
            title = entity.title,
            publisher = entity.publisher,
            featuredImage = entity.featured_image,
            rating = entity.rating,
            sourceUrl = entity.source_url,
            description = entity.description,
            cookingInstructions = entity.cooking_instructions,
            ingredients = entity.ingredients,
            dateAdded = entity.date_added,
            dateUpdated = entity.date_updated
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            publisher = domainModel.publisher,
            featured_image = domainModel.featuredImage,
            rating = domainModel.rating,
            source_url = domainModel.sourceUrl,
            description = domainModel.description,
            cooking_instructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients,
            date_added = domainModel.dateAdded,
            date_updated = domainModel.dateUpdated

        )
    }


    fun toDomainList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}