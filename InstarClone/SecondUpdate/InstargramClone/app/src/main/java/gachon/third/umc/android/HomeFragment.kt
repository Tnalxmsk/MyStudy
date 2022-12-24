package gachon.third.umc.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import gachon.third.umc.android.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    lateinit var binding: FragmentHomeBinding
    val dataStoryList: ArrayList<DataStory> = arrayListOf()
    val adapterStory = DataRvAdapter(dataStoryList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.rvStory.adapter = adapterStory
        // 리사이클러뷰 아이템 간격 조절
        binding.rvStory.addItemDecoration(RecyclerViewDecoration(10))
        applyStoryData()

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
            add(DataStory("name1", R.drawable.ic_profile_default))
            add(DataStory("name2", R.drawable.ic_profile_default))
            add(DataStory("name3", R.drawable.ic_profile_default))
            add(DataStory("name4", R.drawable.ic_profile_default))
            add(DataStory("name5", R.drawable.ic_profile_default))
            add(DataStory("name6", R.drawable.ic_profile_default))
            add(DataStory("name7", R.drawable.ic_profile_default))
            add(DataStory("name8", R.drawable.ic_profile_default))
            add(DataStory("name9", R.drawable.ic_profile_default))
            add(DataStory("name10", R.drawable.ic_profile_default))
        }
    }
}