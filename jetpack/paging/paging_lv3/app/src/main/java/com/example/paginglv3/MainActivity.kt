package com.example.paginglv3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paginglv3.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val myAdapter = MyAdapter()

        with(binding) {
            mainRv.adapter = myAdapter
            mainRv.layoutManager = LinearLayoutManager(this@MainActivity)

            lifecycleScope.launch {
                viewModel.items.collect {
                    myAdapter.submitData(it)
                }
            }
            lifecycleScope.launch {
                myAdapter.loadStateFlow.collect {
                    val isLoadingNext = it.source.append is LoadState.Loading
                    loadingNext.isVisible = isLoadingNext

                    val isLoadingPrev = it.source.prepend is LoadState.Loading
                    loadingPrev.isVisible = isLoadingPrev
                }
            }

            refresh.setOnClickListener {
                myAdapter.refresh()
            }
        }
    }
}