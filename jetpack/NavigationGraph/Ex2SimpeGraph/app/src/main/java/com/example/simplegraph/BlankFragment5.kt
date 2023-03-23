package com.example.simplegraph

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.example.simplegraph.databinding.FragmentBlank5Binding

class BlankFragment5 : Fragment() {
    private var _binding: FragmentBlank5Binding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback : OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.d("BlankFragment5", "pressed")
                view?.let {
                    Navigation.findNavController(it).navigate(R.id.action_blankFragment5_to_blankFragment1)
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlank5Binding.inflate(inflater, container, false)
        with(binding) {
        }
        return binding.root
    }
}