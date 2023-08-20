package com.agape.activitycommunication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.agape.activitycommunication.data.Car
import com.agape.activitycommunication.data.Person
import com.agape.activitycommunication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Receiving extra data from the sender activity.
        val bundleExtra = intent.extras
        val stringData: String? = bundleExtra?.getString("sample data")
        if (!stringData.isNullOrEmpty())
            Toast.makeText(this, stringData, Toast.LENGTH_SHORT).show()

        //Receiving serializable data from sender activity
        val data: Person? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("person", Person::class.java)
        } else {
            intent.getSerializableExtra("person") as? Person
        }
        if (data != null)
            Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show()

        // Receiving Parcelable data from the sending activity
        val parcelableData: Car? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("car", Car::class.java)
        } else {
            intent.getParcelableExtra("car") as? Car
        }
        if (parcelableData != null)
            Toast.makeText(this, parcelableData.toString(), Toast.LENGTH_SHORT).show()

        binding.button1.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("result", "Sample result text")
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}