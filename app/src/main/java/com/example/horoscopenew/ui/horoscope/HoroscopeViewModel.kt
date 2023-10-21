package com.example.horoscopenew.ui.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscopenew.data.providers.HoroscopeProvides
import com.example.horoscopenew.domain.model.HoroscopeInfo
import com.example.horoscopenew.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HoroscopeViewModel @Inject constructor( horoscopeProvides: HoroscopeProvides) : ViewModel(){

    private var _horoscope  = MutableStateFlow<List<HoroscopeInfo>>(emptyList())

    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        val horoscopeInfos = horoscopeProvides.getHoroscopes()
        _horoscope.value = horoscopeInfos
    }



}