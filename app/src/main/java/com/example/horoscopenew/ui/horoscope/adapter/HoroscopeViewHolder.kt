package com.example.horoscopenew.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopenew.databinding.ItemHoroscopeBinding
import com.example.horoscopenew.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding =ItemHoroscopeBinding.bind(view)
    fun render(horoscopeinfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {

        binding.ivHoroscope.setImageResource(horoscopeinfo.img)
        val context = binding.tvTittle.context
        binding.tvTittle.text = context.getString(horoscopeinfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope , newLambda = {onItemSelected(horoscopeinfo)})
        }
    }


    fun startRotationAnimation(view:View , newLambda:() ->Unit){
        view.animate().apply {
            duration = 1000
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction {  newLambda()}
            start()

        }
    }
}