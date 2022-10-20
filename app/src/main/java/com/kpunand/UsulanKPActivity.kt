package com.kpunand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.adapters.MahasiswaKPAdapter
import com.kpunand.adapters.UsulanKPAdapter
import com.kpunand.models.MahasiswaKP
import com.kpunand.models.UsulanKP

class UsulanKPActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UsulanKPAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_usulan_kp)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        lateinit var imageViewback: ImageView
        imageViewback = findViewById(R.id.backButton)
        imageViewback.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init(){
        recyclerView =findViewById(R.id.rvusulan)

        val data = ArrayList<UsulanKP>()
        data.add(UsulanKP(1,null,"Radithya Romero A", "2011521007"))
        data.add(UsulanKP(1,null,"Khalil 'Amir", "201152029"))
        data.add(UsulanKP(1,null,"Alia Nurhikmah", "2011522009"))

        adapter = UsulanKPAdapter(data)
        adapter.setOnClickListener(object : UsulanKPAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val UsulanKPActivity = Intent (this@UsulanKPActivity, DetailUsulanKPActivity::class.java)
                startActivity(UsulanKPActivity)
            }
        })

    }


}