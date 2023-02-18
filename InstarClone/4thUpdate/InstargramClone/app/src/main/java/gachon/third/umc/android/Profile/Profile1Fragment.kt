package gachon.third.umc.android.Profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import gachon.third.umc.android.databinding.FragmentProfile1Binding

class Profile1Fragment : Fragment() {

    lateinit var binding : FragmentProfile1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfile1Binding.inflate(layoutInflater)

        return binding.root
    }
}