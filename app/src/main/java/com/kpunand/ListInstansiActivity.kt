package com.kpunand

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.adapters.ListInstansiAdapter
import com.kpunand.datamodels.CompaniesItem
import com.kpunand.datamodels.ListInstansiResponse
import com.kpunand.retrofit.Configuration
import com.kpunand.retrofit.StoryClient
import kotlinx.android.synthetic.main.activity_instansi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListInstansiActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListInstansiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instansi)

        val adapter = ListInstansiAdapter()

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token", null)

        if (token != null) {
            Log.d("tokennnnn", token)
        }

        val client: StoryClient = Configuration().getService()
        val call: Call<ListInstansiResponse> = client.getInstansi("Bearer " +token)
            call.enqueue(object: Callback<ListInstansiResponse> {
                override fun onResponse(
                    call: Call<ListInstansiResponse>,
                    response: Response<ListInstansiResponse>)
                 {
                    val respon: ListInstansiResponse? = response.body()
                    if (respon != null){
                        val list : List<CompaniesItem> = respon.companies as List<CompaniesItem>
                        adapter.setListIntansi(list)
                    }
                     Log.d("success", response.toString())

                }

                override fun onFailure(call: Call<ListInstansiResponse>, t: Throwable) {
                    Toast.makeText(this@ListInstansiActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            })

        rvInstansi.setHasFixedSize(true)
        rvInstansi.layoutManager = LinearLayoutManager(this)
        rvInstansi.adapter = adapter

        adapter.setOnClickListener(object : ListInstansiAdapter.clickListener{
            override fun onItemClick(position: Int) {
                val DetailInstansiActivity = Intent (this@ListInstansiActivity, DetailLaporanActivity::class.java)
                Toast.makeText(this@ListInstansiActivity, "Udah bisa tekan", Toast.LENGTH_SHORT).show()
            }
        })

    }

}
