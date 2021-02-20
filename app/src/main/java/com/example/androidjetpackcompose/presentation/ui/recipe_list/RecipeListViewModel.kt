package com.example.androidjetpackcompose.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidjetpackcompose.domain.model.Recipe
import com.example.androidjetpackcompose.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject constructor(
    private val recipeRepository: RecipeRepository,
    private @Named("auth_token") val token: String
) :
    ViewModel() {
    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())
    val individualRecipe: MutableState<Recipe> = mutableStateOf(Recipe())

    init {
        viewModelScope.launch {
            val recipess = recipeRepository.search(token = token, page = 2,  query = "beef")
            val recipe = recipeRepository.get(token = token, id = 9)
            individualRecipe.value = recipe
            recipes.value = recipess
        }
    }

}
