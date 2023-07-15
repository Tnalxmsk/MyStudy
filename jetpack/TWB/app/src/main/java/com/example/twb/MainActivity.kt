package com.example.twb

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.twb.databinding.ActivityMainBinding

// 양방향 데이터 결합(Two - Way Binding)
// 데이터와 뷰를 직접 연결해서 서로와 서로에게 영향을 줌

// 1 기존 방식 -> Activity 에서 View 와 연결해서 사용하는 방법
// 2 양방향 데이터 결합 방식 -> ViewModel <->  Activity <-> XML
//                       -> ViewMode <-> Xml
// BindingAdapter -> View 에 속성을 내 맘대로 수정
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // 1번 방식
        /*var age = 0
        binding.plusBtn.setOnClickListener {
            age++
            binding.ageArea.text = age.toString();
        }*/
        binding.vm = viewModel
        binding.lifecycleOwner = this


    }
}