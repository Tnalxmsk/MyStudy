package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val db = TextDatabase.getDatabase(this)

        with(binding) {
            mainInsertBt.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    db.textDao().insert(TextEntity(0, "asdf"))
                    Log.d("MainActivity", db.textDao().getAllData().toString())
                    mainEt.setText("")
                }
            }
            mainGetDataBt.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    Log.d("MainActivity", db.textDao().getAllData().toString())
                }
            }
            mainDeleteBt.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    db.textDao().deleteAllData()
                }
            }
        }
    }
}