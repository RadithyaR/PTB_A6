package com.kpunand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLog = findViewById<Button>(R.id.buttonLogin)
        buttonLog.setOnClickListener{
            val Intent = Intent(this, Main::class.java)
            startActivity(Intent)
        }

    }

}