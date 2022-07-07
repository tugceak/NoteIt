package com.tugceaksoy.noteit.ui.splash

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.tugceaksoy.noteit.databinding.FragmentSplashBinding

import com.tugceaksoy.noteit.ui.MainActivity
import com.tugceaksoy.noteit.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment :  BaseFragment<FragmentSplashBinding>(
    FragmentSplashBinding::inflate
){

    private lateinit var timer: CountDownTimer
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).supportActionBar?.hide()
        (activity as MainActivity).hideBottomNav()

        timer = object :CountDownTimer(3000,1000){
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {
                if(onBoarding()){
                    val action =SplashFragmentDirections.actionSplashFragmentToViewPagerFragment()
                    findNavController().navigate(action)

                }else{
                   val actionHome=SplashFragmentDirections.actionSplashFragmentToHomeFragment()
                    findNavController().navigate(actionHome)
                }
            }
        }
        timer.start()
    }

    private fun onBoarding():Boolean{
        val sharedPref = requireActivity().getSharedPreferences("BoardingScreen", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("isFirstTime",true)
    }
    private fun showIt(){
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}

