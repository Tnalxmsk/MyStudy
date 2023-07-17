package com.example.paging

import android.view.View

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {

    val items : Flow<PagingData<User>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            MyPagingSource()
        }
    ).flow
        .cachedIn(viewModelScope) // lifeCycle 이 변경되어도 데이터 상태 유지
}