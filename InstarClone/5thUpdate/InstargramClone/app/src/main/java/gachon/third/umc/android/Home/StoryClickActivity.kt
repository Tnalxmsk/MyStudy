package gachon.third.umc.android.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import gachon.third.umc.android.databinding.ActivityStoryClickBinding

class StoryClickActivity : AppCompatActivity() {
    lateinit var binding : ActivityStoryClickBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryClickBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        val id = extras!!["id"] as String
        val time = extras!!["time"] as String
        val profileImage = extras["profileImage"] as Int
        val storyImage = extras["storyImage"] as Int

        binding.tvSCVUserId.text = id
        binding.tvSCVUploadTime.text = time
        binding.ibSCVProfileImage.setImageResource(profileImage)
        binding.ibSCVStoryImage.setImageResource(storyImage)

        val handler = Handler(Looper.getMainLooper())

        Thread(){
            var endTime = 500
            while (endTime >= 0){
                handler.post {
                    binding.sbStoryTime.progress = 500 - endTime
                }
                Thread.sleep(10)
                endTime--
                if (endTime == 0){
                    finish()
                }
            }
        }.start()

    }
}