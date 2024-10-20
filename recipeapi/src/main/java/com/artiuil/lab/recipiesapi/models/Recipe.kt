package com.artiuil.lab.recipiesapi.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Recipe(
    val label: String,
    val image: String,
    val calories: Double,
    val url: String,
    val ingredients: List<Ingredient>,
    @Json(name = "ingredientLines")
    val ingredientLines: List<String>
)