package com.artiuil.lab.firediet.ui.screens.recipes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artiuil.lab.recipiesapi.models.Recipe
import com.artiuil.lab.firediet.ui.screens.recipes.components.SearchBar
import com.artiuil.lab.firediet.ui.screens.recipes.components.RecipeList
import com.artiuil.lab.firediet.ui.vm.DishSearchViewModel

@Composable
fun DishSearchScreen(
    viewModel: DishSearchViewModel = viewModel(),
    onDishSelected: (Recipe) -> Unit
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val recipes by viewModel.recipes.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()) {
        SearchBar(
            query = searchQuery,
            onQueryChange = viewModel::onSearchQueryChanged,
            onSearch = viewModel::searchRecipes,
            onClear = viewModel::clearRecipes
        )

        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (errorMessage != null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = errorMessage ?: "Unknown error",
                    color = MaterialTheme.colorScheme.error
                )
            }
        } else {
            RecipeList(recipes = recipes, onDishSelected = onDishSelected)
        }
    }
}