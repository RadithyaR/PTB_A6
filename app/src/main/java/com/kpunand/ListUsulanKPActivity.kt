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
import com.kpunand.adapters.ListUsulanKPAdapter
import com.kpunand.datamodels.ListUsulanResponse
import com.kpunand.datamodels.ProposalsItem
import com.kpunand.retrofit.Configuration
import com.kpunand.retrofit.StoryClient
import kotlinx.android.synthetic.main.activity_instansi.*
import kotlinx.android.synthetic.main.activity_list_usulan_kp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUsulanKPActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListUsulanKPAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_usulan_kp)

        val adapter = ListUsulanKPAdapter()

        val sharedPref: SharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token", null)

        val data = ArrayList<ProposalsItem>()

        rvusulankp.setHasFixedSize(true)
        rvusulankp.layoutManager = LinearLayoutManager(this)
        rvusulankp.adapter = adapter

        val client: StoryClient = Configuration().getService()
        val call: Call<ListUsulanResponse> = client.getUsulan("Bearer" +token)
        call.enqueue(object: Callback<ListUsulanResponse>{
                override fun onResponse(
                    call: Call<ListUsulanResponse>,
                    response: Response<ListUsulanResponse>
                ) {
                    val respon: ListUsulanResponse? = response.body()
                    if (respon!= null){
                        val list: List<ProposalsItem> = respon.proposals as List<ProposalsItem>
                        adapter.setListUsulan(list)
                    }
                    Log.d("success", response.toString())

                    adapter.setOnClickListener(object: ListUsulanKPAdapter.clickListener{
                        override fun onItemClick(position: Int) {
                            val DetailUsulanKPActivity = Intent(this@ListUsulanKPActivity, DetailUsulanKPActivity::class.java)
                            startActivity(DetailUsulanKPActivity)

                            Toast.makeText(this@ListUsulanKPActivity, "berhasil masuk", Toast.LENGTH_SHORT).show()
                        }
                    })
                }

                override fun onFailure(call: Call<ListUsulanResponse>, t: Throwable) {
                    Toast.makeText(this@ListUsulanKPActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })





    }
}
