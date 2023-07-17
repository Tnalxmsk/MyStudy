package com.example.paging.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging.data.GithubResponseItem
import com.example.paging.databinding.RvItemBinding

class MyAdapter : PagingDataAdapter<GithubResponseItem, MyAdapter.MyViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GithubResponseItem>() {
            override fun areItemsTheSame(
                oldItem: GithubResponseItem,
                newItem: GithubResponseItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: GithubResponseItem,
                newItem: GithubResponseItem
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    class MyViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GithubResponseItem) {
            binding.textArea.text = item.name
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MyViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return binding
    }
}