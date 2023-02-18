package gachon.third.umc.android.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gachon.third.umc.android.databinding.ItemStroyBinding

class DataRvAdapter(private val dataStoryList: ArrayList<DataStory>): RecyclerView.Adapter<DataRvAdapter.StoryDataViewHolder>() {

    inner class StoryDataViewHolder(private val binding: ItemStroyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataStory: DataStory) {
            binding.ibStoryImage.setImageResource(dataStory.story_profile)
            binding.tvStoryName.text = dataStory.story_name

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryDataViewHolder {
        val binding = ItemStroyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryDataViewHolder, position: Int) {
        holder.bind(dataStoryList[position])
    }

    override fun getItemCount(): Int  = dataStoryList.size

}