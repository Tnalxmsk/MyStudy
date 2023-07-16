package com.example.coflow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coflow.databinding.UserItemBinding
import com.example.coflow.db.UserEntity

class MyListAdapter : ListAdapter<UserEntity, MyListAdapter.MyListAdapterViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<UserEntity>() {
            override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    class MyListAdapterViewHolder(private val binding : UserItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(userEntity: UserEntity) {
            with(binding) {
                name.text = userEntity.name
                age.text = userEntity.age.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListAdapterViewHolder {
        val binding = MyListAdapterViewHolder(UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false ))
        return binding
    }

    override fun onBindViewHolder(holder: MyListAdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}