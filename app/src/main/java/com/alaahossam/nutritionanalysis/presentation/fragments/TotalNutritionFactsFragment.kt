package com.alaahossam.nutritionanalysis.presentation.fragments

import androidx.navigation.fragment.navArgs
import app.hatrick.core.base.BaseFragment
import com.alaahossam.nutritionanalysis.R
import com.alaahossam.nutritionanalysis.databinding.FragmentTotalNutritionFactsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TotalNutritionFactsFragment : BaseFragment<FragmentTotalNutritionFactsBinding>() {

    private val args by navArgs<TotalNutritionFactsFragmentArgs>()

    override fun getLayoutResourceId(): Int = R.layout.fragment_total_nutrition_facts

    override fun onBindData(binding: FragmentTotalNutritionFactsBinding) {
        super.onBindData(binding)
        binding.recipe = args.recipe
    }
}