package com.kpunand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.adapters.ListUsulanKPAdapter
import com.kpunand.models.ListUsulanKP

class ListUsulanKP : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListUsulanKPAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_usulan_kp)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        lateinit var imageViewback: ImageView
        imageViewback = findViewById(R.id.backButton)
        imageViewback.setOnClickListener {
            intent = Intent(this, Main::class.java)
            startActivity(intent)
        }
    }

    private fun init() {
        recyclerView = findViewById(R.id.rvusulankp)

        val data = ArrayList<ListUsulanKP>()
        data.add(ListUsulanKP(1, null, "Radithya Romero A", "2011521007"))
        data.add(ListUsulanKP(1, null, "Khalil 'Amir", "201152029"))
        data.add(ListUsulanKP(1, null, "Alia Nurhikmah", "2011522009"))
        data.add(ListUsulanKP(1, null, "Radithya Romero A", "2011521007"))
        data.add(ListUsulanKP(1, null, "Khalil 'Amir", "201152029"))
        data.add(ListUsulanKP(1, null, "Alia Nurhikmah", "2011522009"))
        data.add(ListUsulanKP(1, null, "Radithya Romero A", "2011521007"))
        data.add(ListUsulanKP(1, null, "Khalil 'Amir", "201152029"))
        data.add(ListUsulanKP(1, null, "Alia Nurhikmah", "2011522009"))

        adapter = ListUsulanKPAdapter(data)
        adapter.setOnClickListener(object : ListUsulanKPAdapter.clickListener {
            override fun onItemClick(position: Int) {
                val DetailUsulanKP = Intent(this@ListUsulanKP, DetailUsulanKP::class.java)
                startActivity(DetailUsulanKP)
            }
        })

    }
}
