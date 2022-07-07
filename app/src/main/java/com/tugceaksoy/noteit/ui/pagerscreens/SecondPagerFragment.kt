package com.tugceaksoy.noteit.ui.pagerscreens

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.tugceaksoy.notedapp.ui.pagerscreens.ViewPagerFragmentDirections
import com.tugceaksoy.noteit.R
import com.tugceaksoy.noteit.databinding.FragmentSecondPagerBinding

import com.tugceaksoy.noteit.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class SecondPagerFragment : BaseFragment<FragmentSecondPagerBinding>(
    FragmentSecondPagerBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewpager = activity?.findViewById<ViewPager2>(R.id.pager)
        binding.previous.setOnClickListener {  viewpager!!.currentItem = 0
        }
        binding.start.setOnClickListener {
            val action= ViewPagerFragmentDirections.actionViewPagerFragmentToHomeFragment()
            findNavController().navigate(action)
            onBoardingFinished()
        }

        }
    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("BoardingScreen",Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("isFirstTime",false)
        editor.commit()
    }
    }


