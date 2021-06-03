package com.alaahossam.nutritionanalysis.data.repository

import android.util.Log
import com.alaahossam.core.states.Result
import com.alaahossam.nutritionanalysis.data.model.Ingredients
import com.alaahossam.nutritionanalysis.data.model.RecipeDTO
import com.alaahossam.nutritionanalysis.data.network.NutritionAnalysisWebservice
import com.alaahossam.nutritionanalysis.domain.repository.NutritionAnalysisRepository
import com.google.gson.Gson
import com.google.gson.JsonArray
import org.json.JSONObject
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NutritionAnalysisRepositoryImpl
@Inject constructor(private val webservice: NutritionAnalysisWebservice) :
    NutritionAnalysisRepository {
    override suspend fun postIngredients(ingredientsList: List<String>): Result<RecipeDTO> =
        try {
            val ingredients = Ingredients(ingredientsList as MutableList<String>)
            Result.Success(webservice.getNutritionDetails(ingredients))
        } catch (e: Exception) {
            Result.Error(e)
        }
}