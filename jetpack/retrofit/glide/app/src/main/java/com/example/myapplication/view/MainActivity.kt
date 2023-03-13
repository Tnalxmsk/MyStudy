package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.CustomAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        with(binding) {
            with(viewModel) {
                getAllData()
                result.observe(this@MainActivity) {
                    val customAdapter = CustomAdapter(this@MainActivity, it)
                    mainRv.adapter = customAdapter
                    mainRv.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }
    }
}