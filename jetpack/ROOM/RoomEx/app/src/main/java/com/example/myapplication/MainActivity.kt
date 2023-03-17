package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.CustomAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getData()

        with(binding) {
            mainInsertBt.setOnClickListener {
                viewModel.insertData(mainEt.text.toString())
                mainEt.setText("")
            }
            mainGetDataBt.setOnClickListener {
                viewModel.getData()
            }
            mainDeleteBt.setOnClickListener {
                viewModel.removeData()
            }
            viewModel.textList.observe(this@MainActivity) {
                val customAdapter = CustomAdapter(it)
                mainRv.adapter = customAdapter
                mainRv.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}