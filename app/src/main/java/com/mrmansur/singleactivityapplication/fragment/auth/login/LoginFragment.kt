package com.mrmansur.singleactivityapplication.fragment.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mrmansur.singleactivityapplication.R
import com.mrmansur.singleactivityapplication.databinding.FragmentLoginBinding
import com.mrmansur.singleactivityapplication.extension.activityNavController
import com.mrmansur.singleactivityapplication.extension.navigateSafely
import com.mrmansur.singleactivityapplication.manager.AuthManager

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.bSignin.setOnClickListener{
            AuthManager.isAuthorized = true
            activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
        }

        binding.tvSignup.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }
}