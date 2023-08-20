package com.agape.activitycommunication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.agape.activitycommunication.data.Car
import com.agape.activitycommunication.data.Person
import com.agape.activitycommunication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE = 124
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Sending data as extra
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("sample data", "Sample data value")

        binding.button1.setOnClickListener {
            startActivity(intent)
        }

        //Send data in serializable format.
        val person = Person("ABC", 30)
        val intentSerializable = Intent(this, SecondActivity::class.java)
        intentSerializable.putExtra("person", person)
        binding.button2.setOnClickListener {
            startActivity(intentSerializable)
        }

        //Send data in Parcelable format. This is the recommended way. It will improve performance
        val car = Car("Zen", 2001)
        val parcelableIntent = Intent(this, SecondActivity::class.java).apply {
            this.putExtra("car", car)
        }

        binding.button3.setOnClickListener {
            startActivity(parcelableIntent)
        }

        binding.button4.setOnClickListener {
            val intent2 = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent2, REQUEST_CODE)        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE  && resultCode == RESULT_OK){
            val res: String? = data?.getStringExtra("result")
            if (res != null){
                binding.tv1.visibility = View.VISIBLE
                binding.tv1.text = res
            }
        }
    }
}