package com.example.roomflowex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomflowex.databinding.ActivityMainBinding
import com.example.roomflowex.db.TextDataBase
import com.example.roomflowex.db.TextEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// 1. Flow 를 사용하지 않을 때
// 2. Flow 를 사용했을 때

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = TextDataBase.getDataBase(this)

        with(binding) {
            insert.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    val text = TextEntity(0, inputArea.text.toString())
                    db.textDao().insert(text)
                    inputArea.setText("")
                }
            }

            /*getData.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    val resultText = db.textDao().getAllData().toString()

                    withContext(Dispatchers.IO) {
                        resultArea.text = resultText
                    }
                }
            }*/

            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().getAllDataFlow().collect() {
                    val resultText = it.toString()
                    withContext(Dispatchers.IO) {
                        resultArea.text = resultText
                    }
                }
            }

            delete.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    db.textDao().deleteAllData()
                }
            }
        }
    }
}