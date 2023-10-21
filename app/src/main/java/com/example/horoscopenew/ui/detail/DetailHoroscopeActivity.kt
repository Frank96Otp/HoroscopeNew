package com.example.horoscopenew.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.navArgs
import com.example.horoscopenew.R
import com.example.horoscopenew.databinding.ActivityDetailHoroscopeBinding
import com.example.horoscopenew.databinding.ItemHoroscopeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailHoroscopeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHoroscopeBinding
    private  val horosocopeDetaiilViewModel: HoroscopoDetailViewModel by viewModels()

    private  val args:DetailHoroscopeActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailHoroscopeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        args.tpye
    }
}