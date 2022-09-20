package com.willyramad.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.willyramad.sharedpreferences.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirstBinding
    lateinit var shared : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        shared = getSharedPreferences("USERNAME", Context.MODE_PRIVATE)

        binding.btnkirim.setOnClickListener {
            val user = binding.Username.text.toString()
            var adduser = shared.edit()
            adduser.putString("username", user)
            adduser.apply()
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}