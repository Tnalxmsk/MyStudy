package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        with(binding) {
            mainBt.setOnClickListener {
                // 기존 방식
                val testWorkManager = OneTimeWorkRequestBuilder<TestWorkManager>().build()
                //WorkManager.getInstance(this@MainActivity).enqueue(testWorkManager)
                WorkManager.getInstance(this@MainActivity).enqueueUniqueWork("test", ExistingWorkPolicy.KEEP, testWorkManager)
            }
        }
    }
}