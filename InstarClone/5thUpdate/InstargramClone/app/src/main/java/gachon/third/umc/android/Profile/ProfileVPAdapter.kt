package gachon.third.umc.android.Profile

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ProfileVPAdapter(fragment: ProfileFragment) : FragmentStateAdapter(fragment) {
    //나열할 아이템 수
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Profile1Fragment()
            1 -> Profile2Fragment()
            else -> Profile1Fragment()
        }
    }
}