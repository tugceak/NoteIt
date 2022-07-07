package com.tugceaksoy.noteit.ui.pagerscreens

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.tugceaksoy.noteit.R
import com.tugceaksoy.noteit.databinding.FragmentFirstPagerBinding

import com.tugceaksoy.noteit.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class FirstPagerFragment : BaseFragment<FragmentFirstPagerBinding>(
    FragmentFirstPagerBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewpager = activity?.findViewById<ViewPager2>(R.id.pager)
        binding.nextButton.setOnClickListener {
            viewpager!!.currentItem=1

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

}