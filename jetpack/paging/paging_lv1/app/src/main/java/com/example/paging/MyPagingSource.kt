package com.example.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

private const val STARTING_KEY = 1

class MyPagingSource : PagingSource<Int, User>() {


    init {
        Log.d("MyPagingSource", "init")
    }

    // 새로고침을 누르면 어떻게 할 것인지
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        TODO("Not yet implemented")
    }

    // Paging 이 실행되면 어떻게 할 것인지 정하는 부분
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        Log.d("MyPagingSource", "Load")
        Log.d("params.loadSize", params.loadSize.toString())
        Log.d("params.key", params.key.toString())
        val page = params.key ?: STARTING_KEY
        Log.d("page", page.toString())
        val range = page.until(page + params.loadSize)
        Log.d("range", range.toString())
        if (page != STARTING_KEY) {
            delay(3000)
        }

        return LoadResult.Page(
            data = range.map { number ->
                User(
                    id = number,
                    name = "UserNumber is $number"
                )
            },
            prevKey = null,
            nextKey = range.last + 1
        )
    }
}