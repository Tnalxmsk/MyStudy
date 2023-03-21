package com.example.myapplication

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class WorkManager1(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        return Result.success()
    }
}