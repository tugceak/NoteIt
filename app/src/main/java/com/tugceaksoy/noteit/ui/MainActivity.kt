package com.tugceaksoy.noteit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.tugceaksoy.noteit.R

import com.tugceaksoy.noteit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigation, navHostFragment.navController)

    }
 fun hideBottomNav() {
        binding.bottomNavigation.visibility = View.GONE
    }

    fun showBottomNav() {
        binding.bottomNavigation.visibility = View.VISIBLE
    }
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            val builder = AlertDialog.Builder(this)
                .setTitle("EXIT")
                .setMessage("DO YOU WANT TO CLOSE THE APP?")
                .setIcon(android.R.drawable.ic_delete)
                .setPositiveButton("CANCEL") { dialogInterface, _ ->
                    dialogInterface.cancel()
                }
                .setNegativeButton("EXIT") { dialogInterface, _ ->
                    dialogInterface.cancel()
                    android.os.Process.killProcess(android.os.Process.myPid())
                }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        } else {
            supportFragmentManager.popBackStackImmediate()
        }
    }
}