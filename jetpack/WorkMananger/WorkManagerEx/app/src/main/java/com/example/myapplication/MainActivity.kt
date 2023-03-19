package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        SimpleThread().start()

        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
        WorkManager.getInstance(this).enqueue(workManagerA)
    }
}

class SimpleThread : Thread() {
    override fun run() {
        super.run()

        for (i in 1..10) {
            Log.d("MainActivity", "$i")
            sleep(1000)
        }
    }
}