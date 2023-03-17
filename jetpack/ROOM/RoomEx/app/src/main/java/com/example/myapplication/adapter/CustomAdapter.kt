package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemTextRowBinding
import com.example.myapplication.entity.TextEntity

class CustomAdapter(private val dataSet : List<TextEntity>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemTextRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataSet: TextEntity) {
            binding.itemTextTv.text = dataSet.text
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val binding = ItemTextRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}