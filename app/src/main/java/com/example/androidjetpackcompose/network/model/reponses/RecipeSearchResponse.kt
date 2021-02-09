package com.example.androidjetpackcompose.network.model.reponses

import com.example.androidjetpackcompose.network.model.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("result")
    var recipes: List<RecipeDto>
)