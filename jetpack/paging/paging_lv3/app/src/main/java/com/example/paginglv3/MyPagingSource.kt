package com.example.paginglv3

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginglv3.data.Data
import com.example.paginglv3.network.PassengerApi
import kotlinx.coroutines.delay

private const val STARTING_KEY = 1

class MyPagingSource(
    private val passengerApi : PassengerApi
    ) : PagingSource<Int, Data>() {
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        Log.d("getRefreshKey", "start")

        val anchorPosition = state.anchorPosition
        // 적당히 보고 있는 페이지를 찾아서 데이터를 받아옴
        // 페이지를 return
        return anchorPosition?.let { anchorPosition

        state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
            ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val page = params.key ?: STARTING_KEY

        val response = passengerApi.getData(page, params.loadSize)

        val data = response.body()?.data

        if (page != 1) {
            delay(2000)
        }

        if (data == null) {
            return LoadResult.Page(
                data = listOf(),
                prevKey = null,
                nextKey = null
            )
        } else {
            return LoadResult.Page(
                data = data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = page + (params.loadSize / 30)
            )
        }
    }

}