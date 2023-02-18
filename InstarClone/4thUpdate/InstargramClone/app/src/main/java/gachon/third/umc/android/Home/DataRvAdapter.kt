package gachon.third.umc.android.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gachon.third.umc.android.databinding.ItemMyStoryBinding
import gachon.third.umc.android.databinding.ItemStroyBinding
import gachon.third.umc.android.multi_type1

class DataRvAdapter(private val dataStoryList: ArrayList<DataStory>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class MultiViewHolder1(private val binding: ItemMyStoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataStory: DataStory) {
            binding.ibStoryImage.setImageResource(dataStory.story_profile)
            binding.tvStoryName.text = dataStory.story_name
        }
    }
    inner class MultiViewHolder2(private val binding: ItemStroyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataStory: DataStory) {
            binding.ibStoryImage.setImageResource(dataStory.story_profile)
            binding.tvStoryName.text = dataStory.story_name
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataStoryList[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            multi_type1 -> {
                val binding = ItemMyStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder1(binding)
            }
            else -> {
                val binding = ItemStroyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MultiViewHolder2(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (dataStoryList[position].type) {
            multi_type1 -> {
                (holder as MultiViewHolder1).bind(dataStoryList[position])
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as MultiViewHolder2).bind(dataStoryList[position])
                holder.setIsRecyclable(false)
            }
        }
    //holder.bind(dataStoryList[position])
    }

    override fun getItemCount(): Int  = dataStoryList.size

}