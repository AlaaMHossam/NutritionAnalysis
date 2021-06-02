package com.alaahossam.nutritionanalysis.presentation

import android.widget.Toast
import android.widget.Toast.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import app.hatrick.core.base.BaseFragment
import com.alaahossam.core.states.Result
import com.alaahossam.core.states.ViewState
import com.alaahossam.nutritionanalysis.R
import com.alaahossam.nutritionanalysis.data.model.RecipeDTO
import com.alaahossam.nutritionanalysis.databinding.FragmentIngredientInputBinding
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
            when(it){
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
            makeText(requireContext(), data?.totalNutrients.toString(), LENGTH_LONG).show()
        }
    }

    private fun updateErrorUI(exception: Exception?) {
        viewModel.ingredientsInputViewState.value = ViewState.SHOW_ERROR
        makeText(requireContext(), exception?.localizedMessage, LENGTH_LONG).show()
    }
}