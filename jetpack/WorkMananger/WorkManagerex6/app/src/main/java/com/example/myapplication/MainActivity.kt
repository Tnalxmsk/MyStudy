package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.myapplication.WorkManagerTest.Companion.HowMuch

//work manager 진행률 관찰

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManagerTest = OneTimeWorkRequestBuilder<WorkManagerTest>().build()
        WorkManager.getInstance(this).enqueue(workManagerTest)

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workManagerTest.id)
            .observe(this) {workInfo : WorkInfo? ->
                val process = workInfo?.progress
                val value = process?.getInt(HowMuch, 0)
                if (value != 0) {
                    Log.d("MainActivity", value.toString())
                }
                if (value == 100) {
                    Log.d("MainActivity", "end")
                }
            }
    }
}