package com.agape.activitycommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.agape.activitycommunication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundleExtra = intent.extras
        val stringData = bundleExtra?.getString("sample data")
        Toast.makeText(this, stringData, Toast.LENGTH_SHORT).show()
    }
}