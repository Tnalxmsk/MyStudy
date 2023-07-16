package com.example.coflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coflow.databinding.ActivityMainBinding
import com.example.coflow.db.MyDataBase
import com.example.coflow.db.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = MyDataBase.getDataBase(this)
        val myListAdapter = MyListAdapter()

        with(binding) {
            userRv.adapter = myListAdapter
            userRv.layoutManager = LinearLayoutManager(this@MainActivity)

            next.setOnClickListener {
                val intent = Intent(this@MainActivity, NextActivity::class.java)
                startActivity(intent)
            }

            save.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    val n = name.text.toString()
                    val a = age.text.toString()
                    val userEntity = UserEntity(0, n, a.toInt())
                    db.userDao().insert(userEntity)
                }
            }

            get.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    db.userDao().getAllDataWithFlow().collect {
                        withContext(Dispatchers.Main) {
                            myListAdapter.submitList(it)
                        }
                    }
                }
            }

        }
    }
}