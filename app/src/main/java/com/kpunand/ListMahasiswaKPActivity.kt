package com.kpunand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.adapters.ListMahasiswaKPAdapter
import com.kpunand.models.ListMahasiswaKP

class ListMahasiswaKPActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListMahasiswaKPAdapter

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

        val data = ArrayList<ListMahasiswaKP>()
        data.add(ListMahasiswaKP(1,null,"Radithya Romero A", "2011521007"))
        data.add(ListMahasiswaKP(1,null,"Khalil 'Amir", "201152029"))
        data.add(ListMahasiswaKP(1,null,"Alia Nurhikmah", "2011522009"))
        data.add(ListMahasiswaKP(1,null,"Radithya Romero A", "2011521007"))
        data.add(ListMahasiswaKP(1,null,"Khalil 'Amir", "201152029"))
        data.add(ListMahasiswaKP(1,null,"Alia Nurhikmah", "2011522009"))
        data.add(ListMahasiswaKP(1,null,"Radithya Romero A", "2011521007"))
        data.add(ListMahasiswaKP(1,null,"Khalil 'Amir", "201152029"))
        data.add(ListMahasiswaKP(1,null,"Alia Nurhikmah", "2011522009"))

        adapter = ListMahasiswaKPAdapter(data)
        adapter.setOnClickListener(object : ListMahasiswaKPAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val DetailListMahasiswaKP = Intent (this@ListMahasiswaKPActivity, DetailMahasiswaKPActivity::class.java)
                startActivity(DetailListMahasiswaKP)
            }
        })

    }


}