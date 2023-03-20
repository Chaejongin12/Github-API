package com.example.msg_assignment.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.msg_assignment.R
import com.example.msg_assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val username = binding.editText.text.toString()
            if (username.isNotEmpty()) {
                val intent = Intent(this, UserInfoActivity::class.java).apply {
                    putExtra("userName", username)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "유저이름을 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

}