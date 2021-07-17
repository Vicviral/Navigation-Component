package com.example.navigationcomponent

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigationcomponent.databinding.FragmentGroupBinding
import com.example.navigationcomponent.databinding.FragmentProfileBinding
import com.example.navigationcomponent.databinding.FragmentSearchBinding

class GroupFragment : Fragment(R.layout.fragment_group) {

    private lateinit var binding: FragmentGroupBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGroupBinding.bind(view)
    }
}