package com
.tugceaksoy.noteit.ui.pagerscreens

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.tugceaksoy.noteit.databinding.FragmentViewPagerBinding
import com.tugceaksoy.noteit.ui.base.BaseFragment

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class ViewPagerFragment : BaseFragment<FragmentViewPagerBinding>(
    FragmentViewPagerBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
        val adapter = ViewPagerAdapter(arrayListOf(
            FirstPagerFragment(), SecondPagerFragment()
        ),requireActivity().supportFragmentManager,lifecycle)
        binding.pager.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as AppCompatActivity).supportActionBar?.show()

    }


}