package com.alaahossam.nutritionanalysis.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Nutrient(
    @SerializedName("label")
    val label: String? = "",
    @SerializedName("quantity")
    val quantity: Double? = 0.0,
    @SerializedName("unit")
    val unit: String? = ""
) : Parcelable