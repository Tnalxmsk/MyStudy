package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        val myData : Data = workDataOf(
            "a" to 10,
            "b" to 20
        )
        //val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
        //WorkManager.getInstance(this).enqueue(workManagerA)
        val workManagerB = OneTimeWorkRequestBuilder<WorkManagerB>().setInputData(myData).build()
        WorkManager.getInstance(this).enqueue(workManagerB)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManagerB.id)
            .observe(this) { info ->
                if (info != null && info.state.isFinished) {
                    val result = info.outputData.getInt("result", 10000)
                    Log.d("MainActivity", result.toString())
                }
            }
    }
}