package com.alaahossam.nutritionanalysis.data.network

import com.alaahossam.nutritionanalysis.data.model.Ingredients
import com.alaahossam.nutritionanalysis.data.model.RecipeDTO
import retrofit2.http.*

interface NutritionAnalysisWebservice {

    @POST("nutrition-details?app_id=$appId&app_key=$appKey")
    suspend fun getNutritionDetails(@Body ingredient: Ingredients): RecipeDTO

    @GET("nutrition-data?app_id=$appId&app_key=$appKey&1%20large%20apple")
    suspend fun getNutritionData(): String
}

private const val appId = "252da88e"
private const val appKey = "37ff87ed51b17747df8e7e3d98a772f5"

