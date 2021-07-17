package com.example.navigationcomponent

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.confirmButton.setOnClickListener {
            verify()
        }
    }

    private fun verify() {
        if (binding.userName.text.toString().isNullOrEmpty() || binding.userYear.text.toString().isNullOrEmpty()) {
            Toast.makeText(context, "Empty Field", Toast.LENGTH_SHORT).show()
            return
        }else {
            val name = binding.userName.text.toString()
            val year = binding.userYear.text.toString()

            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(name, year)
            findNavController().navigate(action)
        }
    }
}