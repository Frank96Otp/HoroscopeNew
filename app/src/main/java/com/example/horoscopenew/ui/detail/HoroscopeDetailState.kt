package com.example.horoscopenew.ui.detail

sealed class HoroscopeDetailState {

    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val sign:String , val horoscope:String):HoroscopeDetailState()
}