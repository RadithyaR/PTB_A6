package com.kpunand

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.adapters.ListMahasiswaKPAdapter
import com.kpunand.datamodels.ListMahasiswaKPResponse
import com.kpunand.datamodels.InternshipsItem
import com.kpunand.retrofit.Configuration
import com.kpunand.retrofit.StoryClient
import kotlinx.android.synthetic.main.activity_list_mahasiswa_kp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListMahasiswaKPActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListMahasiswaKPAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_mahasiswa_kp)

        val adapter = ListMahasiswaKPAdapter()

        val sharedPref: SharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token", null)

        val data = ArrayList<InternshipsItem>()

        rvmahasiswakp.setHasFixedSize(true)
        rvmahasiswakp.layoutManager = LinearLayoutManager(this)
        rvmahasiswakp.adapter = adapter

        val client: StoryClient = Configuration().getService()
        val call: Call<ListMahasiswaKPResponse> = client.getMahasiswa("Bearer" +token)
        call.enqueue(object: Callback<ListMahasiswaKPResponse>{
            override fun onResponse(
                call: Call<ListMahasiswaKPResponse>,
                response: Response<ListMahasiswaKPResponse>
            ) {
                val respon: ListMahasiswaKPResponse? = response.body()
                if (respon!= null){
                    val list: List<InternshipsItem> = respon.internships as List<InternshipsItem>
                    adapter.setListMahasiswa(list)
                }
                Log.d("success", response.toString())

                adapter.setOnClickListener(object: ListMahasiswaKPAdapter.ClickListener{
                    override fun onItemClick(position: Int) {
                        val DetailMahasiswaKPActivity = Intent(this@ListMahasiswaKPActivity, DetailMahasiswaKPActivity::class.java)
                        startActivity(DetailMahasiswaKPActivity)

                        Toast.makeText(this@ListMahasiswaKPActivity, "berhasil", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            override fun onFailure(call: Call<ListMahasiswaKPResponse>, t: Throwable) {
                Toast.makeText(this@ListMahasiswaKPActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })





    }
}
