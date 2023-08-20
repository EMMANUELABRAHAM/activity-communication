    package com.agape.activitycommunication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agape.activitycommunication.data.Car
import com.agape.activitycommunication.data.Person
import com.agape.activitycommunication.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {

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
            //Sending data through application class
            val app = application as ApplicationClass
            app.globalVariable = "Data updated from Sender Activity"
        }
    }
}