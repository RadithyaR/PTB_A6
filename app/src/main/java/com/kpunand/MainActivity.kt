package com.kpunand

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token", " ")

        if (token==null){
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonMenu = findViewById<Button>(R.id.buttonMenumhs)
        buttonMenu.setOnClickListener {
            val Intent = Intent(this, ListMahasiswaKPActivity::class.java)
            startActivity(Intent)
        }
        val buttonUsul = findViewById<Button>(R.id.buttonUsulan)
        buttonUsul.setOnClickListener {
            val Intent = Intent(this, ListUsulanKPActivity::class.java)
            startActivity(Intent)
        }
        val buttonIns = findViewById<Button>(R.id.buttonInstansi)
        buttonIns.setOnClickListener {
            val Intent = Intent(this, ListInstansiActivity::class.java)
            startActivity(Intent)
        }
        val buttonLap = findViewById<Button>(R.id.buttonLaporan)
        buttonLap.setOnClickListener {
            val Intent = Intent(this, ListLaporanActivity::class.java)
            startActivity(Intent)
        }

        val buttonOut = findViewById<Button>(R.id.buttonLogout)
        buttonOut.setOnClickListener{

            val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putString("token", null)
                apply()
            }

            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}