package com.example.horoscopenew.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopenew.databinding.ActivityDetailHoroscopeBinding
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

        horosocopeDetaiilViewModel.getHoroscope(args.tpye.name)

        initUi()
    }

    private fun initUi() {
        initUiState()
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
    }

    private fun loadingState() {
        binding.progressBar.isVisible = true
    }

    private fun errorState() {
        TODO("Not yet implemented")
    }
}