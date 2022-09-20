package com.example.onboarding.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onboarding.R
import com.example.onboarding.databinding.FragmentViewPagerBinding
import com.example.onboarding.onboarding.screen.FirstFragment
import com.example.onboarding.onboarding.screen.SecFragment
import com.example.onboarding.onboarding.screen.ThirdFragment

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(
            inflater,
            container,
            false
        )

        val fragmentList = arrayListOf(
            FirstFragment(),
            SecFragment(),
            ThirdFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.ViewPager2.adapter = adapter

        binding.nextButton.setOnClickListener{
            binding.ViewPager2.currentItem += 1
        }

        binding.skipTxt.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
            onBoardingFinished()
        }

        binding.wormDotsIndicator.attachTo(binding.ViewPager2)

        return binding.root

    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}