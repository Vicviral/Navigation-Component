package com.example.navigationcomponent

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigationcomponent.databinding.FragmentTermsAndConditionsBinding

class TermsFragment : Fragment(R.layout.fragment_terms_and_conditions) {

    private lateinit var binding: FragmentTermsAndConditionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTermsAndConditionsBinding.bind(view)
    }
}