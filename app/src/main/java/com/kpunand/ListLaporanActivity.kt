package com.kpunand

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.adapters.ListLaporanKPAdapter
import com.kpunand.models.ListLaporanKP



class ListLaporanActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListLaporanKPAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_laporan)

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
        recyclerView =findViewById(R.id.rvlaporan)

        val data = ArrayList<ListLaporanKP>()
        data.add(ListLaporanKP(1,null,"Radithya Romero", "2011521007", "Grab"))
        data.add(ListLaporanKP(1,null,"Alia Nurhikmah ", "2011521009", "Gojek"))


        adapter = ListLaporanKPAdapter(data)
        adapter.setOnClickListener(object : ListLaporanKPAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val DetailListLaporanKP = Intent (this@ListLaporanActivity, DetailLaporanActivity::class.java)
                startActivity(DetailListLaporanKP)
            }
        })
    }

}