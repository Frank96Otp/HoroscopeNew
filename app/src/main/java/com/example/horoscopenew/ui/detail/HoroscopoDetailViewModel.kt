package com.example.horoscopenew.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horoscopenew.databinding.ActivityDetailHoroscopeBinding
import com.example.horoscopenew.domain.model.PredictionModel
import com.example.horoscopenew.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class HoroscopoDetailViewModel @Inject constructor(private val  getPredictionUseCase:GetPredictionUseCase) : ViewModel(){

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state : StateFlow<HoroscopeDetailState> = _state

    fun getHoroscope(sign:String){
        viewModelScope.launch() {

            _state.value = HoroscopeDetailState.Loading
            val result: PredictionModel? = withContext(Dispatchers.IO){ getPredictionUseCase(sign) }
            if(result != null){
                _state.value = HoroscopeDetailState.Success(result.sign, result.horoscope)
            }else{
                _state.value = HoroscopeDetailState.Error("ha ocurrido un error  intentelo mas tarde")
            }
        }


    }
}