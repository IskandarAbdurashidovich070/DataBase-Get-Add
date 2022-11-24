package com.example.musoboqa

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.musoboqa.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addFragment2)
        }

        binding.btnShow.setOnClickListener {
            findNavController().navigate(R.id.showFragment)
        }



        return binding.root
    }


}