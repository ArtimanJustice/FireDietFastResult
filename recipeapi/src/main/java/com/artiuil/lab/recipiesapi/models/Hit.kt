package com.artiuil.lab.recipiesapi.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hit(
    val recipe: Recipe
)