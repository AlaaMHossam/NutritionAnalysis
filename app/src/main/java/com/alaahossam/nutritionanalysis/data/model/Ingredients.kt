package com.alaahossam.nutritionanalysis.data.model

import com.google.gson.annotations.SerializedName

data class Ingredients(
    @SerializedName("ingr")
    val ingredientsList: MutableList<String>
)