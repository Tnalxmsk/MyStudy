package com.example.myapplication

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class WorkManager2(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        test1()
        test2()

        return Result.success()
    }

    suspend fun test1() {
        for (i in 1..10) {
            delay(1000)
            Log.d("WorkManager2", i.toString())
        }
    }
    suspend fun test2() {
        for (i in 1..10) {
            delay(1000)
            Log.d("WorkManager2", i.toString())
        }
    }
}