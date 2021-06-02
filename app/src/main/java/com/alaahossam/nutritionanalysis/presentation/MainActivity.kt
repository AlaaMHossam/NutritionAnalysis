package com.alaahossam.nutritionanalysis.presentation

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.alaahossam.core.base.BaseActivity
import com.alaahossam.nutritionanalysis.R
import com.alaahossam.nutritionanalysis.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutResourceId(): Int = R.layout.activity_main

    override fun onBindData(binding: ActivityMainBinding) {
        super.onBindData(binding)

        val navController = findNavController(R.id.fragment)
        binding.toolbar.setupWithNavController(navController)
    }
}