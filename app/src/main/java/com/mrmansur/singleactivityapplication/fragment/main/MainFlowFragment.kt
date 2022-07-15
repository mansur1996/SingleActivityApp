package com.mrmansur.singleactivityapplication.fragment.main

import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mrmansur.singleactivityapplication.R
import com.mrmansur.singleactivityapplication.databinding.FlowFragmentMainBinding
import com.mrmansur.singleactivityapplication.fragment.BaseFlowFragment

class MainFlowFragment : BaseFlowFragment(
    R.layout.flow_fragment_main, R.id.nav_host_fragment_main
){
    private val binding by viewBinding(FlowFragmentMainBinding::bind)

    override fun setupNavigation(navController: NavController) {
        binding.bottomNavigation.setupWithNavController(navController)
    }
}