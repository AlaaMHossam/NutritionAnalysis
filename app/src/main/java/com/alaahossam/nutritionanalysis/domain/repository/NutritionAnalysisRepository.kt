package com.alaahossam.nutritionanalysis.domain.repository

import com.alaahossam.core.states.Result
import com.alaahossam.nutritionanalysis.data.model.RecipeDTO

interface NutritionAnalysisRepository {

    suspend fun postIngredients(ingredientsList: List<String>): Result<RecipeDTO>
}