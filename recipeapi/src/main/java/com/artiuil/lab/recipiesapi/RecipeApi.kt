package com.artiuil.lab.recipiesapi

import com.artiuil.lab.recipiesapi.models.EdamamResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("api/recipes/v2")
    suspend fun searchRecipes(
        @Query("type") type: String = "public",
        @Query("q") query: String
    ): EdamamResponse
}