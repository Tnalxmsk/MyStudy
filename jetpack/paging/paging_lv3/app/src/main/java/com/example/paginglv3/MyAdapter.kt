package com.example.paginglv3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.paginglv3.data.Data
import com.example.paginglv3.databinding.RvItemBinding

class MyAdapter : PagingDataAdapter<Data, MyAdapter.MyViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }

        }
    }

    class MyViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Data) {
            with(binding) {
                textArea.text = item._id
                imgArea.load(item.airline[0].logo)
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }
}