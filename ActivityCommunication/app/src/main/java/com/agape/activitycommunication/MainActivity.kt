    package com.agape.activitycommunication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agape.activitycommunication.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("sample data", "Sample data value")

        binding.button1.setOnClickListener {
            startActivity(intent)
        }
    }
}