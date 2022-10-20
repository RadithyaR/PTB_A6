package com.kpunand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMenu = findViewById<Button>(R.id.buttonMenumhs)
        buttonMenu.setOnClickListener{
            val Intent = Intent(this, MahasiswaKP::class.java)
            startActivity(Intent)
        }
        val buttonUsul = findViewById<Button>(R.id.buttonUsulan)
        buttonUsul.setOnClickListener{
            val Intent = Intent(this, UsulanKP::class.java)
            startActivity(Intent)
        }
        val buttonIns = findViewById<Button>(R.id.buttonInstansi)
        buttonIns.setOnClickListener{
            val Intent = Intent(this, InstansiActivity::class.java)
            startActivity(Intent)
        }
        val buttonLap = findViewById<Button>(R.id.buttonLaporan)
        buttonLap.setOnClickListener{
            val Intent = Intent(this, ListLaporanActivity::class.java)
            startActivity(Intent)
        }
    }
}