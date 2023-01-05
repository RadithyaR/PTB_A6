package com.kpunand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class DetailMahasiswaKPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mahasiswa_kp)

        val buttonLogbook = findViewById<Button>(R.id.logbook)
        buttonLogbook.setOnClickListener {
            val Intent = Intent(this, ListLogbookActivity::class.java)
            startActivity(Intent)
        }

        val buttonSeminar = findViewById<Button>(R.id.seminarKP)
        buttonSeminar.setOnClickListener {
            val Intent = Intent(this, SeminarKPActivity::class.java)
            startActivity(Intent)
        }

        val buttonBatal = findViewById<Button>(R.id.batalkanKP)
        buttonBatal.setOnClickListener {
            val Intent = Intent(this, PembatalanKPActivity::class.java)
            startActivity(Intent)
        }
    }
}
