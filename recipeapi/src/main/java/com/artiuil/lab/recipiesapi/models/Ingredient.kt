package com.artiuil.lab.recipiesapi.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ingredient(
    val text: String,
    val weight: Double
)