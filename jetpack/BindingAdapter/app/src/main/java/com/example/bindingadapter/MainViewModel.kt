package com.example.bindingadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _point = MutableLiveData(0)

    val point : LiveData<Int> = _point
    val myPointType : LiveData<MyPointType> = Transformations.map(_point) {
        when {
            it > 80 -> {MyPointType.BIG }
            it > 50 -> {MyPointType.MIDDLE}
            it > 30 -> {MyPointType.SMALL}
            else -> {MyPointType.VARY_SMALL}
        }
    }

    fun pointPlus() {
        _point.value = _point.value?.plus(10)
    }
}
// 4가지 -> BIG / MIDDLE / SMALL / VARY_SMALL
enum class MyPointType {
    BIG,
    MIDDLE,
    SMALL,
    VARY_SMALL
}