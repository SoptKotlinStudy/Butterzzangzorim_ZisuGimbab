package org.sopt.signinactivitythird

import android.app.Activity
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import org.sopt.signinactivitythird.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("TAG","onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtonClickEvent()
        joinButtonClickEvent()
    }

    private fun initButtonClickEvent() {
        binding.loginButton.setOnClickListener {
            val userID = binding.loginIdInput.text
            val userPassword = binding.loginPasswordInput.text
            if (userID.isNullOrBlank() || userPassword.isNullOrBlank()) {
                Toast.makeText(
                    this@MainActivity,
                    "아이디/비밀번호를 확인해주세요!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                val intent = Intent(this, Home::class.java)
                startActivity(intent)

                Toast.makeText(
                    this@MainActivity,
                    "로그인 성공",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun joinButtonClickEvent() {
        binding.joinButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
            super.onStart()
            Log.d("TAG","onStart")
        }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onPause")
    }
}
