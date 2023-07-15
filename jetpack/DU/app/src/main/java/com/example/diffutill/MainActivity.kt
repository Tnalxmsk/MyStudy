package com.example.diffutill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutill.databinding.ActivityMainBinding
import com.example.diffutill.databinding.CatItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val catAdapter = CatListAdapter()

        with(binding) {
            catRv.adapter = catAdapter
            catRv.layoutManager = LinearLayoutManager(this@MainActivity)
            catAdapter.submitList(firstSetupData())

            Handler(Looper.getMainLooper()).postDelayed({
                catAdapter.submitList(secondSetupData())
            }, 3000)
        }
    }

    private fun firstSetupData() : ArrayList<DataModel> {
        val cat1 = DataModel(1, "cat1", 10)
        val cat2 = DataModel(2, "cat1", 11)
        val cat3 = DataModel(3, "cat1", 12)
        val cat4 = DataModel(4, "cat1", 13)
        val cat5 = DataModel(5, "cat1", 14)

        val arr1 = ArrayList<DataModel>()

        arr1.add(cat1)
        arr1.add(cat2)
        arr1.add(cat3)
        arr1.add(cat4)
        arr1.add(cat5)

        return arr1
    }

    private fun secondSetupData() : ArrayList<DataModel> {
        val cat3 = DataModel(3, "cat3", 12)
        val cat4 = DataModel(4, "cat4", 13)
        val cat5 = DataModel(5, "cat5", 14)
        val cat6 = DataModel(6, "cat6", 15)
        val cat7 = DataModel(7, "cat7", 16)
        val cat8 = DataModel(8, "cat8", 17)

        val arr2 = ArrayList<DataModel>()

        arr2.add(cat3)
        arr2.add(cat4)
        arr2.add(cat5)
        arr2.add(cat6)
        arr2.add(cat7)
        arr2.add(cat8)

        return arr2
    }
}

// DB에서 값을 받아와서 새롭게 RecyclerView 에 보여줄 일이 있는데
// 이걸 매번 DB에 값이 바뀔 때마다 RecyclerView 를 새롭게 그려주는 작업이
// 불필요하니깐 변경된 데이터만 바꿔줄 수 있도록 연산을 효율적으로 하기위해
// DiffUtil / ListAdapter 를 사용함