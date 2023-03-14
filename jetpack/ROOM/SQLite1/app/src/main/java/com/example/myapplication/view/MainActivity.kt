package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.SQLiteHelperSample

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var db : SQLiteHelperSample
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = SQLiteHelperSample(this)
        with(binding) {
            mainInsertBt.setOnClickListener {
                db.insert(mainEt.text.toString())
                mainEt.setText("")
            }
            mainGetAllBt.setOnClickListener {
                val arr = db.getAllData()
                mainResultTv.text = arr.toString()
            }
            mainDeleteBt.setOnClickListener {
                db.deleteAll()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}