package com.kpunand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.adapters.MahasiswaKPAdapter
import com.kpunand.models.MahasiswaKP

class MahasiswaKPActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MahasiswaKPAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_mahasiswa_kp)

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
        recyclerView =findViewById(R.id.rvmahasiswakp)

        val data = ArrayList<MahasiswaKP>()
        data.add(MahasiswaKP(1,null,"Radithya Romero A", "2011521007"))
        data.add(MahasiswaKP(1,null,"Khalil 'Amir", "201152029"))
        data.add(MahasiswaKP(1,null,"Alia Nurhikmah", "2011522009"))
        data.add(MahasiswaKP(1,null,"Radithya Romero A", "2011521007"))
        data.add(MahasiswaKP(1,null,"Khalil 'Amir", "201152029"))
        data.add(MahasiswaKP(1,null,"Alia Nurhikmah", "2011522009"))
        data.add(MahasiswaKP(1,null,"Radithya Romero A", "2011521007"))
        data.add(MahasiswaKP(1,null,"Khalil 'Amir", "201152029"))
        data.add(MahasiswaKP(1,null,"Alia Nurhikmah", "2011522009"))

        adapter = MahasiswaKPAdapter(data)
        adapter.setOnClickListener(object : MahasiswaKPAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val DetailMahasiswaKPActivity = Intent (this@MahasiswaKPActivity, DetailMahasiswaKPActivity::class.java)
                startActivity(DetailMahasiswaKPActivity)
            }
        })

    }


}