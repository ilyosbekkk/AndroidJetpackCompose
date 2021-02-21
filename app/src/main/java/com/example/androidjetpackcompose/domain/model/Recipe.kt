package com.example.androidjetpackcompose.domain.model



data class Recipe(
    val id: Int? = null,
    val title: String? = null,
    val publisher: String? = null,
    val featuredImage: String? = null,
    val rating: Int? = 0,
    val sourceUrl: String? = null,
    val description: String? = null,
    val cookingInstructions: List<String>? = null,
    val ingredients: List<String>? = null,
    val dateAdded: String? = null,
    val dateUpdated: String? = null

)