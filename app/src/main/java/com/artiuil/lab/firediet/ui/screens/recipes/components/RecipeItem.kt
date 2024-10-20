package com.artiuil.lab.firediet.ui.screens.recipes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.artiuil.lab.recipiesapi.models.Recipe

@Composable
fun RecipeItem(recipe: Recipe, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(recipe.image),
            contentDescription = recipe.label,
            modifier = Modifier
                .size(80.dp)
                .padding(end = 16.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = recipe.label, style = MaterialTheme.typography.titleMedium)
            Text(
                text = "${recipe.calories.toInt()} calories",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}