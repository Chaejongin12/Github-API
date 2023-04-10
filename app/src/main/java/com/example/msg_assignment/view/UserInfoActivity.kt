package com.example.msg_assignment.view

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.msg_assignment.databinding.ActivityResultBinding
import com.example.msg_assignment.viewModel.ResultViewModel

class UserInfoActivity : AppCompatActivity() {
    private val viewModel by viewModels<ResultViewModel>()

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?){
        viewModel.searchUser(intent.getStringExtra("userName") ?: "")
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.userInfo.observe(this){
            println("안녕 $it")
            Glide.with(this).load(it.userProfile).into(binding.userProfile)
            binding.userId.text = it.userId
            binding.userName.text = it.userName
            binding.userIntroduction.text = it.userIntroduction
            binding.userFollow.text = it.userFollow.toString()
            binding.userFollowing.text = it.userFollowing.toString()
        }
    }
}