package com.example.horoscopenew.ui.horoscope

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.horoscopenew.databinding.FragmentHoroscopeBinding
import com.example.horoscopenew.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private lateinit var horoscopeAdapter:HoroscopeAdapter

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        initRecyclerView()
        initUiState()
    }

    private fun initRecyclerView() {
        horoscopeAdapter = HoroscopeAdapter()

        binding.rvHoroscope.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = horoscopeAdapter

        }


    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeViewModel.horoscope.collect(){
                    Log.i("frank", "todo bien $it")

                    horoscopeAdapter.updateList(it)

                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


}