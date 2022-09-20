package com.example.onboarding.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.onboarding.databinding.FragmentBaseBinding
import com.example.onboarding.util.Screen

class BaseFragment(val screen: Screen) : Fragment() {

    private lateinit var binding: FragmentBaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseBinding.inflate(inflater ,container ,false)

        binding.advantageTxt.text = screen.advantage
        binding.descriptionTxt.text = screen.description

        // Inflate the layout for this fragment
        return binding.root
    }
}