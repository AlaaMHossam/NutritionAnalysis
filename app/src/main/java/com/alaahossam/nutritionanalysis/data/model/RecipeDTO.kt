package com.alaahossam.nutritionanalysis.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeDTO(
    @SerializedName("error")
    val error: String = "",
    @SerializedName("calories")
    val calories: Int? = 0,
    @SerializedName("cautions")
    val cautions: List<String>? = listOf(),
    @SerializedName("dietLabels")
    val dietLabels: List<String>? = listOf(),
    @SerializedName("healthLabels")
    val healthLabels: List<String>? = listOf(),
    @SerializedName("totalNutrients")
    val totalNutrients: TotalNutrients? = TotalNutrients(),
    @SerializedName("uri")
    val uri: String? = "",
    @SerializedName("yield")
    val yield: Double? = 0.0
) : Parcelable