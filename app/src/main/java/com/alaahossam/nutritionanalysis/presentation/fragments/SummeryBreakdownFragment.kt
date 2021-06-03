package com.alaahossam.nutritionanalysis.presentation.fragments

import app.hatrick.core.base.BaseFragment
import com.alaahossam.nutritionanalysis.R
import com.alaahossam.nutritionanalysis.databinding.FragmentSummeryBreakdownBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SummeryBreakdownFragment : BaseFragment<FragmentSummeryBreakdownBinding>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_summery_breakdown


}