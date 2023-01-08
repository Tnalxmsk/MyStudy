package gachon.third.umc.android.Profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gachon.third.umc.android.R
import gachon.third.umc.android.multi_type1
import gachon.third.umc.android.multi_type2

class ProfileStoryHighlightRVAdapter(private val dataStoryPlusList : ArrayList<DataProfileStoryHigh>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class MultiViewHolder1(view: View) :RecyclerView.ViewHolder(view) {
        fun bind(dataProfileStoryHigh: DataProfileStoryHigh) {

        }
    }
    inner class MultiViewHolder2(view: View) :RecyclerView.ViewHolder(view) {
        fun bind(dataProfileStoryHigh: DataProfileStoryHigh) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View?
        return when(viewType) {
            multi_type1 -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_story_highlight_plus,
                    parent,
                    false)
                MultiViewHolder1(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_story_highlight,
                parent,
                false
                )
                MultiViewHolder2(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataStoryPlusList[position].type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (dataStoryPlusList[position].type) {
            multi_type1 -> {
                (holder as MultiViewHolder1).bind(dataStoryPlusList[position])
                holder.setIsRecyclable(false)
            }
            else -> {
                (holder as MultiViewHolder2).bind(dataStoryPlusList[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    override fun getItemCount(): Int = dataStoryPlusList.size


}