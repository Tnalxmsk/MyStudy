package com.example.navi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val manager = supportFragmentManager

        with(binding) {
            mainBt1.setOnClickListener {
                val transaction = manager.beginTransaction()
                val fragment1 = BlankFragment1()
                transaction.replace(R.id.main_frame_lay, fragment1)
                transaction.commit()
            }
            mainBt2.setOnClickListener {
                val transaction = manager.beginTransaction()
                val fragment2 = BlankFragment2()
                transaction.replace(R.id.main_frame_lay, fragment2)
                transaction.commit()
            }
        }

    }
}