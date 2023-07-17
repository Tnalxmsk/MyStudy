package com.example.paging.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging.data.GithubResponseItem
import com.example.paging.network.GitApi
import kotlinx.coroutines.delay

private const val STARTING_KEY = 1

class MyPagingSource(private val githubService : GitApi
) : PagingSource<Int, GithubResponseItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubResponseItem> {

        val page = params.key ?: STARTING_KEY

        val response = githubService.getData(page, params.loadSize)

        val data = response.body()

        if (page != 1) {
            delay(2000)
        }

        if (data != null) {
            return LoadResult.Page(
                data = data,
                prevKey = null,
                nextKey = page + (params.loadSize / 30)
            )
        } else {
            return LoadResult.Page(
                data = listOf(),
                prevKey = null,
                nextKey = null
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, GithubResponseItem>): Int? {
        return null
    }
}