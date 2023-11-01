package com.example.horoscopenew.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopenew.R
import com.example.horoscopenew.databinding.ActivityDetailHoroscopeBinding
import com.example.horoscopenew.domain.model.HoroscopeModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DetailHoroscopeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHoroscopeBinding
    private  val horosocopeDetaiilViewModel: HoroscopoDetailViewModel by viewModels()

    private  val args:DetailHoroscopeActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailHoroscopeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        horosocopeDetaiilViewModel.getHoroscope(args.tpye)

        initUi()
    }

    private fun initUi() {
        initListeners()
        initUiState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {onBackPressed() }
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horosocopeDetaiilViewModel.state.collect{
                    when(it){
                        is HoroscopeDetailState.Error -> errorState()
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Success ->successState(it)

                    }
                }
            }
        }
    }

    private fun successState(horoscopeDetailState: HoroscopeDetailState.Success) {
        binding.progressBar.isVisible = false
        binding.tvDetail.text = horoscopeDetailState.sign
        binding.tvBody.text = horoscopeDetailState.horoscope

       val image =   when(horoscopeDetailState.horoscopeModel){
            HoroscopeModel.Aries -> R.drawable.detail_aries
            HoroscopeModel.Taurus -> R.drawable.detail_taurus
            HoroscopeModel.Gemini -> R.drawable.detail_gemini
            HoroscopeModel.Cancer -> R.drawable.detail_cancer
            HoroscopeModel.Leo -> R.drawable.detail_leo
            HoroscopeModel.Virgo -> R.drawable.detail_virgo
            HoroscopeModel.Libra -> R.drawable.detail_libra
            HoroscopeModel.Scorpio -> R.drawable.detail_scorpio
            HoroscopeModel.Sagittarius -> R.drawable.detail_sagittarius
            HoroscopeModel.Capricorn -> R.drawable.detail_capricorn
            HoroscopeModel.Aquarius -> R.drawable.detail_aquarius
            HoroscopeModel.Pisces -> R.drawable.detail_pisces
        }

        binding.ivDetail.setImageResource(image)
    }

    private fun loadingState() {
        binding.progressBar.isVisible = true
    }

    private fun errorState() {
        TODO("Not yet implemented")
    }
}