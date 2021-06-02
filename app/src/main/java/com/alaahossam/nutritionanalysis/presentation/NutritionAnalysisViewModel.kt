package com.alaahossam.nutritionanalysis.presentation

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaahossam.core.states.Result
import com.alaahossam.core.states.ViewState
import com.alaahossam.nutritionanalysis.data.model.RecipeDTO
import com.alaahossam.nutritionanalysis.domain.usecases.PostIngredientsCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutritionAnalysisViewModel
@Inject constructor(private val postIngredientsCase: PostIngredientsCase) : ViewModel() {

    val ingredientsInputLiveData = MutableLiveData<String>()
    val ingredientsInputViewState = MutableLiveData<ViewState>()
    val enableAnalysisMediatorLiveData = MediatorLiveData<Boolean>()

    val recipeLiveData = MutableLiveData<Result<RecipeDTO>>()

    init {
        enableAnalysisMediatorLiveData.addSource(ingredientsInputLiveData) { enableAnalysis() }
    }

    private fun enableAnalysis() {
        enableAnalysisMediatorLiveData.postValue(ingredientsInputLiveData.value?.isNotEmpty())
    }

    fun postIngredients() {
        viewModelScope.launch {
            ingredientsInputViewState.value = ViewState.LOADING
            recipeLiveData.postValue(postIngredientsCase.invoke(ingredientsInputLiveData.value.toString()))
        }
    }
}