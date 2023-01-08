package gachon.third.umc.android.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import gachon.third.umc.android.databinding.ActivityProfileModifyBinding

class ProfileModifyActivity : AppCompatActivity() {
    lateinit var binding : ActivityProfileModifyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileModifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //데이터를 받는 변수
        val dataName = intent.getStringExtra("name")
        val dataId = intent.getStringExtra("id")
        val dataIntro = intent.getStringExtra("intro")

        //뷰에 데이터 전달
        binding.etProfileModName.setText(dataName)
        binding.etProfileModId.setText(dataId)
        binding.etProfileModIntro.setText(dataIntro)

        // X버튼 클릭 이벤트
        binding.ibProfileModClose.setOnClickListener {
            finish()
        }
        // 프로필 편집 체크 버튼 이벤트
        binding.ibProfileModCheck.setOnClickListener {

            val userIdLength = binding.etProfileModId.text.toString().length
            if (userIdLength > 0){
                val intent = Intent(this@ProfileModifyActivity, ProfileFragment::class.java).apply {
                    val edId = binding.etProfileModId.text.toString()
                    val edName = binding.etProfileModName.text.toString()
                    val edIntro = binding.etProfileModIntro.text.toString()
                    putExtra("edId", edId)
                    putExtra("edName", edName)
                    putExtra("edIntro", edIntro)
                }
                setResult(RESULT_OK, intent)
                finish()
            }
            else {
                Toast.makeText(this@ProfileModifyActivity,
                    "1자리 이상 입력해주세요",
                    Toast.LENGTH_SHORT)
                    .show()
            }
            binding.etProfileModId.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {

                }

            })

            }
        }


    }


