package gachon.third.umc.android.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import gachon.third.umc.android.R
import gachon.third.umc.android.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    lateinit var binding: FragmentHomeBinding
    val dataStoryList: ArrayList<DataStory> = arrayListOf()
    val adapterStory = DataRvAdapter(dataStoryList)

    val dataPostList: ArrayList<DataPost> = arrayListOf()
    val adapterPost = DataPostRvAdapter(dataPostList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.rvStory.adapter = adapterStory
        binding.rvPost.adapter = adapterPost
        // 리사이클러뷰 아이템 간격 조절
        binding.rvStory.addItemDecoration(RecyclerViewDecoration(10))
        applyStoryData()
        applyPostData()

        return binding.root
    }


    // story 데이터 추가 함수
    private fun applyStoryData() {
        val managerStory = LinearLayoutManager(activity)
        managerStory.reverseLayout = true
        managerStory.stackFromEnd = true
        binding.rvStory.layoutManager = managerStory
        binding.rvStory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        dataStoryList.apply {
            add(DataStory("내 스토리", R.drawable.ic_profile_default,1, "1시간 전", R.drawable.image_neck))
            add(DataStory("name1", R.drawable.ic_profile_default, 2, "2시간 전", R.drawable.image_neck))
            add(DataStory("name2", R.drawable.ic_profile_default, 2, "3시간 전", R.drawable.image_neck))
            add(DataStory("name3", R.drawable.ic_profile_default, 2, "5시간 전", R.drawable.image_neck))
            add(DataStory("name4", R.drawable.ic_profile_default, 2, "6시간 전", R.drawable.image_neck))
            add(DataStory("name5", R.drawable.ic_profile_default, 2, "10시간 전", R.drawable.image_neck))
            add(DataStory("name6", R.drawable.ic_profile_default, 2, "12시간 전", R.drawable.image_neck))
            add(DataStory("name7", R.drawable.ic_profile_default, 2, "15시간 전", R.drawable.image_neck))
            add(DataStory("name8", R.drawable.ic_profile_default, 2, "17시간 전", R.drawable.image_neck))
            add(DataStory("name9", R.drawable.ic_profile_default, 2, "19시간 전", R.drawable.image_neck))
            add(DataStory("name10", R.drawable.ic_profile_default, 2, "23시간 전", R.drawable.image_neck))
        }
        adapterStory.setOnItemClickListener(object : DataRvAdapter.OnItemClickListener {
            override fun onItemClick(v: View, data: DataStory, pos: Int) {
                val intent = Intent(activity, StoryClickActivity::class.java).apply {
                    putExtra("id", data.story_name)
                    putExtra("time", data.time)
                    putExtra("profileImage", data.story_profile)
                    putExtra("storyImage", data.story_image)
                }
                startActivity(intent)
            }

        })
    }

    private fun applyPostData() {
        val managerPost = LinearLayoutManager(activity)
        binding.rvPost.layoutManager = managerPost
        binding.rvPost.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        dataPostList.apply {
            add(
                DataPost("my_muldaeng", "좋아요 100개", "my_muldaeng 안녕하세요 물댕입니다.",
                "댓글 131개 모두 보기", "1시간 전", R.drawable.image_neck
                )
            )
            add(
                DataPost("name2", "좋아요 1550개", "name2 물댕입니다.",
                "댓글 131개 모두 보기", "1시간 전", R.drawable.image_neck
                )
            )
            add(
                DataPost("name3", "좋아요 141개", "name3 안녕하세요",
                "댓글 131개 모두 보기", "1시간 전", R.drawable.image_neck
                )
            )
            add(
                DataPost("name4", "좋아요 104개", "name4 안녕하세요 물댕입니다.",
                "댓글 131개 모두 보기", "1시간 전", R.drawable.image_neck
                )
            )
            add(
                DataPost("name5", "좋아요 115개", "name5 안녕하세요 물댕입니다.",
                "댓글 131개 모두 보기", "1시간 전", R.drawable.image_neck
                )
            )
            add(
                DataPost("name6", "좋아요 705개", "name6 안녕하세요 물댕입니다.",
                "댓글 131개 모두 보기", "1시간 전", R.drawable.image_neck
                )
            )
            add(
                DataPost("name7", "좋아요 602개", "name7 안녕하세요 물댕입니다.",
                "댓글 131개 모두 보기", "1시간 전", R.drawable.image_neck
                )
            )
            add(
                DataPost("name8", "좋아요 458개", "name8 안녕하세요 물댕입니다.",
                "댓글 131개 모두 보기", "1시간 전", R.drawable.image_neck
                )
            )
            add(
                DataPost("name9", "좋아요 191개", "name9 안녕하세요 물댕입니다.",
                "댓글 131개 모두 보기", "1시간 전", R.drawable.image_neck
                )
            )

        }

    }
}