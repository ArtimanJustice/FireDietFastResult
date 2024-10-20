package com.artiuil.lab.firediet.ui.screens.recipes.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import com.artiuil.lab.recipiesapi.models.Recipe

@Composable
fun RecipeList(recipes: List<Recipe>, onDishSelected: (Recipe) -> Unit) {
    LazyColumn {
        items(recipes) { recipe ->
            RecipeItem(recipe = recipe, onClick = { onDishSelected(recipe) })
            HorizontalDivider()
        }
    }
}