package com.example.horoscopenew.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopenew.databinding.ItemHoroscopeBinding
import com.example.horoscopenew.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding =ItemHoroscopeBinding.bind(view)
    fun render(horoscopeinfo: HoroscopeInfo) {
        binding.ivHoroscope.setImageResource(horoscopeinfo.img)
        val context = binding.tvTittle.context
        binding.tvTittle.text = context.getString(horoscopeinfo.name)
    }
}