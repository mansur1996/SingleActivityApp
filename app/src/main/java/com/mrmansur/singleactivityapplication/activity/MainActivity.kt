package com.mrmansur.singleactivityapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.mrmansur.singleactivityapplication.R
import com.mrmansur.singleactivityapplication.databinding.ActivityMainBinding
import com.mrmansur.singleactivityapplication.manager.AuthManager

/**
 * We built this app using only one Activity
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()

    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        when{
            AuthManager.isAuthorized -> {
                navGraph.setStartDestination(R.id.mainFlowFragment)
            }
            !AuthManager.isAuthorized -> {
                navGraph.setStartDestination(R.id.authFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}