package com.kpunand

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.kpunand.datamodels.DetailUsulanResponse
import com.kpunand.retrofit.Configuration
import com.kpunand.retrofit.StoryClient
import kotlinx.android.synthetic.main.activity_detail_usulan_kp.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUsulanKPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_usulan_kp)

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token", null)

        val getName = intent.getStringExtra("perusahaanProposal")
        namaDetail.text = getName.toString()

        //tes token
        if (token != null) {
            Log.d("tokennnnn", token)
        }

        val client: StoryClient = Configuration().getService()


        val call: Call<DetailUsulanResponse> = client.getDetailUsulan("Bearer"+token, 31)//mengakses proposals dengan id 31
        call.enqueue(object: Callback<DetailUsulanResponse>{
            override fun onResponse(
                call: Call<DetailUsulanResponse>,
                response: Response<DetailUsulanResponse>
            ) {
                // tes respon
                val respon = response.body()
                Log.d("detaildebug", respon.toString())

                if (respon!= null){
                    namaDetail.text = respon.name
                    mulaiDetail.text = respon.startAt
                    selesaiDetail.text = respon.endAt
                    pesertaDetail.text = respon.jumlah.toString()
                }
            }

            override fun onFailure(call: Call<DetailUsulanResponse>, t: Throwable) {
                Toast.makeText(this@DetailUsulanKPActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
        val buttonAcc = findViewById<Button>(R.id.btnTerima)
        buttonAcc.setOnClickListener {
            Toast.makeText(this@DetailUsulanKPActivity, "KP Diterima", Toast.LENGTH_SHORT).show()

        }

        val buttonRej = findViewById<Button>(R.id.btnTolak)
        buttonRej.setOnClickListener {
            Toast.makeText(this@DetailUsulanKPActivity, "KP Ditolak", Toast.LENGTH_SHORT).show()
        }
    }
}