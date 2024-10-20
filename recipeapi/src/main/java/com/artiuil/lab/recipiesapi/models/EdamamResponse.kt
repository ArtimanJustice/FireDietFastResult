package com.artiuil.lab.recipiesapi.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EdamamResponse(
    val hits: List<Hit>
)