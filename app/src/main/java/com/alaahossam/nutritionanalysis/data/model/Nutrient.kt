package com.alaahossam.nutritionanalysis.data.model

import com.google.gson.annotations.SerializedName

data class Nutrient(
    @SerializedName("label")
    val label: String? = "",
    @SerializedName("quantity")
    val quantity: Double? = 0.0,
    @SerializedName("unit")
    val unit: String? = ""
)