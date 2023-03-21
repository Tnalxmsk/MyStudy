package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

// WorkManager Chaining
// A -> 순서 상관 없이 실행 돼도 괜찮음
// B -> 순서 상관 없이 실행 돼도 괜찮음
// C -> 무조건 A / B 모두 실행 된 뒤에 실행 되어야 함

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
        val workManagerB = OneTimeWorkRequestBuilder<WorkManagerB>().build()
        val workManagerC = OneTimeWorkRequestBuilder<WorkManagerC>().build()

//        WorkManager.getInstance(this).enqueue(workManagerA)
//        WorkManager.getInstance(this).enqueue(workManagerB)
//        WorkManager.getInstance(this).enqueue(workManagerC)

        WorkManager.getInstance(this)
            .beginWith(listOf(workManagerA, workManagerB))
            .then(workManagerC)
            .enqueue()
    }
}