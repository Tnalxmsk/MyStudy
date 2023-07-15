package com.example.diffutill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutill.databinding.CatItemBinding

class CatListAdapter : ListAdapter<DataModel, CatListAdapter.CatViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<DataModel>() {
            override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
                // 고유값 비교
                return oldItem.catId == newItem.catId
            }

            override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
                // 내용
                return oldItem == newItem
            }

        }

    }

    class CatViewHolder(private val binding: CatItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataModel) {
            with(binding) {
                catId.text = item.catId.toString()
                catName.text = item.catName
                catAge.text = item.catAge.toString()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = CatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}