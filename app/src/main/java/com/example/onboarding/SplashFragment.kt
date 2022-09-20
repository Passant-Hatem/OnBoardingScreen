package com.example.onboarding

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.onboarding.databinding.FragmentSplashBinding

class SplashFragment :Fragment(){

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater ,container ,false)
        Handler(Looper.getMainLooper()).postDelayed({
            if (onBoardingFinished())
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            else
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
        }, 2000)

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.podcast)
        Glide.with(this)
            .load(bitmap)
            .circleCrop()
            .into(binding.logoImg)

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

}