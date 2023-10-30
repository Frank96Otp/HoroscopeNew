package com.example.horoscopenew.data

import android.util.Log
import com.example.horoscopenew.data.network.HoroscopeApiService
import com.example.horoscopenew.domain.Repository
import com.example.horoscopenew.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService:HoroscopeApiService):Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        kotlin.runCatching { apiService.getHoroscope(sign)}
            .onSuccess {  return it.toDomain() }
            .onFailure { Log.i("frank", "ha ocurrido un error ${it.message} ") }
        return null
    }

}