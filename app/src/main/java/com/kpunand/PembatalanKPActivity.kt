package com.kpunand

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PembatalanKPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembatalan_kp)

        val buttonBatal = findViewById<Button>(R.id.batalkanKP)
        buttonBatal.setOnClickListener {
            Toast.makeText(this@PembatalanKPActivity, "Mahasiswa KP dibatalkan", Toast.LENGTH_SHORT).show()
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
    }
}