package com.example.androidjetpackcompose.network.model.reponses

import com.example.androidjetpackcompose.network.model.model.RecipeNetworkEntity
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("resuls")
    var recipes: List<RecipeNetworkEntity>
)