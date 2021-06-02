package com.alaahossam.nutritionanalysis.data.di

import com.alaahossam.nutritionanalysis.data.network.NutritionAnalysisWebservice
import com.alaahossam.nutritionanalysis.data.repository.NutritionAnalysisRepositoryImpl
import com.alaahossam.nutritionanalysis.domain.repository.NutritionAnalysisRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NutritionAnalysisDIModule {

    @Singleton
    @Provides
    internal fun providesNutritionAnalysisWebservice(retrofit: Retrofit):
            NutritionAnalysisWebservice = retrofit.create(NutritionAnalysisWebservice::class.java)

    @Singleton
    @Provides
    internal fun providesNutritionAnalysisRepository(NutritionAnalysisRepositoryImpl: NutritionAnalysisRepositoryImpl)
            : NutritionAnalysisRepository = NutritionAnalysisRepositoryImpl
}