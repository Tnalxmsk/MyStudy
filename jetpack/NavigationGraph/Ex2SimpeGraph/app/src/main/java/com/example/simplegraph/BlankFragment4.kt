package com.example.simplegraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.simplegraph.databinding.FragmentBlank4Binding

class BlankFragment4 : Fragment() {
    private var _binding: FragmentBlank4Binding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlank4Binding.inflate(inflater, container, false)
        with(binding) {
            mainBt.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(R.id.action_blankFragment4_to_blankFragment5)
            }
        }
        return binding.root
    }
}