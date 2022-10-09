package com.example.madpractical5_20012011017

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.madpractical5_20012011017.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setSupportActionBar(binding.toolbar)

        binding.playButton.setOnClickListener {
            //var res = binding.playButton.contentDescription.toString()
            //Log.i("HELLO:", "$res")
            Intent(applicationContext, MyService::class.java).putExtra(
                MyService.DATA_KEY,
                MyService.DATA_VALUE
            ).apply { startService(this) }
        }

        binding.stopButton.setOnClickListener {
            Intent(applicationContext, MyService::class.java).apply { stopService(this) }
        }
    }
}