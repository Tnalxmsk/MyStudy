package com.example.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging.databinding.ItemViewBinding

class MyPagingAdapter : PagingDataAdapter<User, MyPagingAdapter.UserViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object :DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

        }
    }

    class UserViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(user: User) {
           binding.id.text = user.id.toString()
           binding.userName.text = user.name
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return binding
    }
}