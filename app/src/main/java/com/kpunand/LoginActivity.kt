package com.kpunand

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.kpunand.datamodels.LoginResponse
import com.kpunand.retrofit.Configuration
import com.kpunand.retrofit.StoryClient
import kotlinx.android.synthetic.main.activity_login.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //cek ada token atau ndak, kalo ada langsung ke MainActivity
        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val ada = sharedPref.getString("token",null)

        val buttonLog = findViewById<Button>(R.id.buttonLogin)
        buttonLog.setOnClickListener {

            val progressBar = findViewById<ProgressBar>(R.id.progressBarLogin)
            progressBar.visibility = View.GONE

            val username = findViewById<TextInputEditText>(R.id.username).username.getText().toString()
            val password = findViewById<TextInputEditText>(R.id.password).password.getText().toString()
            Log.d("login debug", username + " " + password)

            val client: StoryClient = Configuration().getService()

            progressBar.visibility = View.VISIBLE

            val call: Call<LoginResponse> = client.login(username, password)

            call.enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                    val respon: LoginResponse? = response.body();

                    if (respon != null && respon.status == "success" && respon.user?.username == "198201182008121002") {
                        Toast.makeText(this@LoginActivity, "Berhasil Login", Toast.LENGTH_SHORT).show()

                        val token : String? = respon.authorisation?.token

                        val sharedPref = getSharedPreferences("prefs", MODE_PRIVATE)
                        with (sharedPref.edit()) {
                            putString("token", token)
                            apply()
                        }

                        intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                    else if (respon != null && respon.status == "success" && respon.user?.username != "198201182008121002"){
                        Toast.makeText(this@LoginActivity, "Anda bukan pak husnil", Toast.LENGTH_SHORT).show()
                    }

                    else {
                        Toast.makeText(this@LoginActivity,"Username dan password anda salah", Toast.LENGTH_SHORT).show()
                    }

                    progressBar.visibility = View.GONE
                }
            })
        }

    }

}