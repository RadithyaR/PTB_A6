package com.kpunand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.adapters.ListLaporanKPAdapter
import com.kpunand.adapters.ListLogbookAdapter
import com.kpunand.models.ListLaporanKP
import com.kpunand.models.ListLogbook

class ListLogbookActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListLogbookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_logbook)

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
        recyclerView =findViewById(R.id.rvlogbook)

        val data = ArrayList<ListLogbook>()
        data.add(ListLogbook(1,"Hari / Tanggal","Senin / 17 - 10 - 2022"))
        data.add(ListLogbook(2,"Hari / Tanggal","Selasa / 18 - 10 - 2022"))
        data.add(ListLogbook(3,"SHari / Tanggal","Rabu / 19 - 10 - 2022"))

        adapter = ListLogbookAdapter(data)
        adapter.setOnClickListener(object : ListLogbookAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val ListLogbook = Intent (this@ListLogbookActivity, DetailLogbookActivity::class.java)
                startActivity(ListLogbook)
            }
        })

    }
}
