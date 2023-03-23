package com.example.simplegraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.simplegraph.databinding.FragmentBlank1Binding

class BlankFragment1 : Fragment() {
    private var _binding: FragmentBlank1Binding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlank1Binding.inflate(inflater, container, false)
        with(binding) {
            mainBt.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.action_blankFragment1_to_blankFragment2)
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}