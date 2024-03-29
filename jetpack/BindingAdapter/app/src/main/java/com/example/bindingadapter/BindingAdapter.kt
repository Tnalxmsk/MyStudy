package com.example.bindingadapter

import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("myProgress")
fun myProgressSetting(view:ImageView, myPointType: MyPointType) {
    when(myPointType) {
        MyPointType.BIG -> {view.setColorFilter(Color.parseColor("#ff4040"))}
        MyPointType.MIDDLE -> {view.setColorFilter(Color.parseColor("#fa8072"))}
        MyPointType.SMALL -> {view.setColorFilter(Color.parseColor("#ffb6c1"))}
        MyPointType.VARY_SMALL -> {view.setColorFilter(Color.parseColor("#000000"))}
    }
}