package com.alaahossam.nutritionanalysis.presentation.fragments

import android.widget.Toast.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import app.hatrick.core.base.BaseFragment
import com.alaahossam.core.states.Result
import com.alaahossam.core.states.ViewState
import com.alaahossam.nutritionanalysis.R
import com.alaahossam.nutritionanalysis.data.model.RecipeDTO
import com.alaahossam.nutritionanalysis.databinding.FragmentIngredientInputBinding
import com.alaahossam.nutritionanalysis.presentation.NutritionAnalysisViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IngredientInputFragment : BaseFragment<FragmentIngredientInputBinding>() {

    private val viewModel by viewModels<NutritionAnalysisViewModel>()

    override fun getLayoutResourceId(): Int = R.layout.fragment_ingredient_input

    override fun onBindData(binding: FragmentIngredientInputBinding) {
        super.onBindData(binding)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun initView() {
        super.initView()
        viewModel.recipeLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is Result.Success -> updateSuccessUI(it.data)
                is Result.Error -> updateErrorUI(it.exception)
            }
        })
    }

    private fun updateSuccessUI(data: RecipeDTO?) {
        viewModel.ingredientsInputViewState.value = ViewState.SHOW_CONTENT
        if (data?.error?.isNotBlank() == true)
            makeText(requireContext(), data.error, LENGTH_LONG).show()
        else {
            viewModel.recipeLiveData.postValue(null)
            findNavController().navigate(
                IngredientInputFragmentDirections
                    .actionIngredientInputFragmentToTotalNutritionFactsFragment(data!!)
            )
        }
    }

    private fun updateErrorUI(exception: Exception?) {
        viewModel.ingredientsInputViewState.value = ViewState.SHOW_ERROR
        makeText(requireContext(), exception?.localizedMessage, LENGTH_LONG).show()
    }
}