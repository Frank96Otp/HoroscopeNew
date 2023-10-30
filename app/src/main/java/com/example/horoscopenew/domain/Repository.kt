package com.example.horoscopenew.domain

import com.example.horoscopenew.domain.model.PredictionModel

interface Repository {

    suspend fun getPrediction(sign:String): PredictionModel?
}