package com.kpunand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class DataPembimbingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pembimbing)

        val buttonDelete = findViewById<Button>(R.id.no)
        buttonDelete.setOnClickListener {
            Toast.makeText(this@DataPembimbingActivity, "Dihapus", Toast.LENGTH_SHORT).show()
        }
    }
}