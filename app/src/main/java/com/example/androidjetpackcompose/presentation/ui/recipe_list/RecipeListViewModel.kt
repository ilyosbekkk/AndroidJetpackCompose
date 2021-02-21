package com.example.androidjetpackcompose.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

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
    val query = mutableStateOf("")

    init {
        newSearch(query = query.value)
    }

    fun newSearch(query: String) {
        viewModelScope.launch {
            val result = recipeRepository.search(token = token, page = 2, query = query
            )
            recipes.value = result
        }
    }

    fun onInputChanged(newInput: String) {
        this.query.value = newInput
    }


}
