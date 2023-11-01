package com.example.horoscopenew.ui.detail

import com.example.horoscopenew.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {

    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val sign:String , val horoscope:String, val horoscopeModel: HoroscopeModel):HoroscopeDetailState()
}