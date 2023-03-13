package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemTestRowBinding
import com.example.myapplication.model.Plant

class CustomAdapter(val context: Context, private val dataSet : List<Plant>) :RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemTestRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(plant : Plant) {
            with(binding) {
                itemTv.text = plant.name
                Glide.with(context)
                    .load(plant.imageUrl)
                    .into(itemIv)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val binding = ItemTestRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}