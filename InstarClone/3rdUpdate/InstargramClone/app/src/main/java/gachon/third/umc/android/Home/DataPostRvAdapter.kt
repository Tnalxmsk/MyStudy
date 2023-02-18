package gachon.third.umc.android.Home

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gachon.third.umc.android.databinding.ItemPostBinding

class DataPostRvAdapter(private val dataPostList: ArrayList<DataPost>) : RecyclerView.Adapter<DataPostRvAdapter.PostDataViewHolder>() {

    inner class PostDataViewHolder(private val binding : ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataPost: DataPost) {

            binding.tvPostId.text = dataPost.post_id
            binding.tvPostLike.text = dataPost.post_like
            binding.tvPostIntro.text = spannableText(dataPost.post_intro, dataPost.post_id.length)
            binding.tvPostComment.text = dataPost.post_comment
            binding.tvPostTime.text = dataPost.post_time

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostDataViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostDataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostDataViewHolder, position: Int) {
        holder.bind(dataPostList[position])
    }

    override fun getItemCount(): Int = dataPostList.size

    private fun spannableText(content: String, size: Int) : CharSequence?{
        val texData: String = content
        val builder = SpannableStringBuilder(texData)
        val boldSpan = StyleSpan(Typeface.BOLD)

        builder.setSpan(boldSpan, 0, size, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        return builder
    }
}
