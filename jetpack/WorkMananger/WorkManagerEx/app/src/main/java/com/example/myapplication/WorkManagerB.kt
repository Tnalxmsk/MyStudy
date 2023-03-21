package com.example.myapplication

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class WorkManagerB(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {
        val a = inputData.getInt("a", 100000)
        val b = inputData.getInt("b", 200000)
        val c = inputData.getInt("c", 300000)

        Log.d("WorkManagerB", a.toString())
        Log.d("WorkManagerB", b.toString())
        Log.d("WorkManagerB", c.toString())

        val output : Data = workDataOf("result" to 10)

        return Result.success(output)
    }
}