package com.alaahossam.nutritionanalysis.domain.usecases

import com.alaahossam.core.states.Result
import com.alaahossam.nutritionanalysis.data.model.RecipeDTO
import com.alaahossam.nutritionanalysis.domain.repository.NutritionAnalysisRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostIngredientsCase
@Inject constructor(private val nutritionAnalysisRepository: NutritionAnalysisRepository){
    suspend operator fun invoke(ingredients: String):Result<RecipeDTO> =
        withContext(IO){
            nutritionAnalysisRepository.postIngredients(ingredients.lines())
        }
}