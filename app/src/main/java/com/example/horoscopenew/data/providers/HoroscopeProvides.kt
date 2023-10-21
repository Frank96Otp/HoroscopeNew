package com.example.horoscopenew.data.providers

import com.example.horoscopenew.domain.model.HoroscopeInfo
import javax.inject.Inject


class HoroscopeProvides @Inject constructor() {

    fun getHoroscopes():List<HoroscopeInfo>{
        return listOf(
            HoroscopeInfo.Aries,
            HoroscopeInfo.Taurus,
            HoroscopeInfo.Gemini,
            HoroscopeInfo.Cancer,
            HoroscopeInfo.Leo,
            HoroscopeInfo.Virgo,
            HoroscopeInfo.Libra,
            HoroscopeInfo.Scorpio,
            HoroscopeInfo.Sagittarius,
            HoroscopeInfo.Capricorn,
            HoroscopeInfo.Aquarius,
            HoroscopeInfo.Pisces
        )
    }
}