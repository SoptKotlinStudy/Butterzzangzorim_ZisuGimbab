package org.sopt.signinactivitythird

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("TAG","onCreate")

        setContentView(R.layout.activity_home)
    }
}