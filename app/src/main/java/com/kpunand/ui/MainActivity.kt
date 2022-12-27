package com.kpunand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.kpunand.Notifikasi.Companion.CHANNEL_ID


class MainActivity : AppCompatActivity() {


    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            val Intent = Intent(this, InstansiActivity::class.java)
            startActivity(Intent)
        }
        val buttonLap = findViewById<Button>(R.id.buttonLaporan)
        buttonLap.setOnClickListener {
            val Intent = Intent(this, ListLaporanActivity::class.java)
            startActivity(Intent)
        }

        notificationManager = NotificationManagerCompat.from(this)

        val buttonNotif = findViewById<Button>(R.id.btn_button)
        buttonNotif.setOnClickListener {
            val title = "Notifikasi"
            val message = "Ini adalah pesan yang masuk"
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(1, builder.build())

            }
        }
    }
}