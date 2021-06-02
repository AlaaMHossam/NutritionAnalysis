package com.alaahossam.nutritionanalysis.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TotalNutrients(
    @SerializedName("CA")
    val cA: Nutrient? = Nutrient(),
    @SerializedName("CHOCDF")
    val cHOCDF: Nutrient? = Nutrient(),
    @SerializedName("CHOLE")
    val cHOLE: Nutrient? = Nutrient(),
    @SerializedName("ENERC_KCAL")
    val eNERCKCAL: Nutrient? = Nutrient(),
    @SerializedName("FAMS")
    val fAMS: Nutrient? = Nutrient(),
    @SerializedName("FAPU")
    val fAPU: Nutrient? = Nutrient(),
    @SerializedName("FASAT")
    val fASAT: Nutrient? = Nutrient(),
    @SerializedName("FAT")
    val fAT: Nutrient? = Nutrient(),
    @SerializedName("FE")
    val fE: Nutrient? = Nutrient(),
    @SerializedName("FIBTG")
    val fIBTG: Nutrient? = Nutrient(),
    @SerializedName("FOLAC")
    val fOLAC: Nutrient? = Nutrient(),
    @SerializedName("FOLDFE")
    val fOLDFE: Nutrient? = Nutrient(),
    @SerializedName("FOLFD")
    val fOLFD: Nutrient? = Nutrient(),
    @SerializedName("K")
    val k: Nutrient? = Nutrient(),
    @SerializedName("MG")
    val mG: Nutrient? = Nutrient(),
    @SerializedName("NA")
    val nA: Nutrient? = Nutrient(),
    @SerializedName("NIA")
    val nIA: Nutrient? = Nutrient(),
    @SerializedName("P")
    val p: Nutrient? = Nutrient(),
    @SerializedName("PROCNT")
    val pROCNT: Nutrient? = Nutrient(),
    @SerializedName("RIBF")
    val rIBF: Nutrient? = Nutrient(),
    @SerializedName("SUGAR")
    val sUGAR: Nutrient? = Nutrient(),
    @SerializedName("THIA")
    val tHIA: Nutrient? = Nutrient(),
    @SerializedName("TOCPHA")
    val tOCPHA: Nutrient? = Nutrient(),
    @SerializedName("VITA_RAE")
    val vITARAE: Nutrient? = Nutrient(),
    @SerializedName("VITB12")
    val vITB12: Nutrient? = Nutrient(),
    @SerializedName("VITB6A")
    val vITB6A: Nutrient? = Nutrient(),
    @SerializedName("VITC")
    val vITC: Nutrient? = Nutrient(),
    @SerializedName("VITD")
    val vITD: Nutrient? = Nutrient(),
    @SerializedName("VITK1")
    val vITK1: Nutrient? = Nutrient(),
    @SerializedName("WATER")
    val wATER: Nutrient? = Nutrient(),
    @SerializedName("ZN")
    val zN: Nutrient? = Nutrient()
) : Parcelable