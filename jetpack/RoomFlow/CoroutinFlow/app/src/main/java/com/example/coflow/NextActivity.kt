package com.example.coflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coflow.databinding.ActivityNextBinding
import com.example.coflow.db.MyDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = MyDataBase.getDataBase(this)
        val myListAdapter = MyListAdapter()
        with(binding) {
            userRv.adapter = myListAdapter
            userRv.layoutManager = LinearLayoutManager(this@NextActivity)

            read.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    db.userDao().getAllDataWithFlow().collect {
                        withContext(Dispatchers.Main) {
                            myListAdapter.submitList(it)
                        }
                    }
                }
            }
            update.setOnClickListener {
                val userId = id.text.toString().toInt()
                CoroutineScope(Dispatchers.IO).launch {
                    val result = db.userDao().getAllData()
                    val userEntity = result[userId]
                    userEntity.name = "update 된 id"
                    db.userDao().update(userEntity)
                }
            }

            remove.setOnClickListener {
                val userId = id.text.toString().toInt()
                CoroutineScope(Dispatchers.IO).launch {
                    val result = db.userDao().getAllData()
                    val userEntity = result[userId]

                    db.userDao().delete(userEntity)
                }
            }
        }
    }
}