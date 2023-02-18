package gachon.third.umc.android

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import gachon.third.umc.android.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {

    lateinit var binding: FragmentProfileBinding
    // registerFroActivityResult 객체
    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == RESULT_OK){
            val resultId = result.data?.getStringExtra("edId")
            val resultName = result.data?.getStringExtra("edName")
            val resultIntro = result.data?.getStringExtra("edIntro")

            binding.tvProfileUserId.text = resultId
            binding.tvProfileName.text = resultName
            binding.tvProfileIntro.text = resultIntro
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        // intro의 length에 따라 visibility 설정
        val introLength = binding.tvProfileIntro.text.toString().length
        if (introLength != 0) {
            binding.tvProfileIntro.visibility = View.VISIBLE
        }
        else if (introLength == 0){
            binding.tvProfileIntro.visibility = View.GONE
        }

        //버튼 클릭 이벤트
        binding.btProfileSet.setOnClickListener {
            val intent = Intent(activity, ProfileModifyActivity::class.java).apply {
                // 데이터를 담을 변수 초기화
                val name = binding.tvProfileName.text.toString()
                val id = binding.tvProfileUserId.text.toString()
                val intro = binding.tvProfileIntro.text.toString()

                // 데이터 전달
                putExtra("name", name)
                putExtra("id", id)
                putExtra("intro", intro)
            }
            resultLauncher.launch(intent)
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.d("tag", "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("tag", "onResume")
        // 생명주기를 이용하여 Intro의 길이에 따라 Visibility 설정
        val introLength = binding.tvProfileIntro.text.toString().length
        Log.d("Length", "$introLength")
        if (introLength != 0) {
            binding.tvProfileIntro.visibility = View.VISIBLE
        }
        else if (introLength == 0){
            binding.tvProfileIntro.visibility = View.GONE
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("tag", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("tag", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}