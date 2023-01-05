package com.kpunand.retrofit

import android.icu.number.IntegerWidth
import com.kpunand.datamodels.*
import retrofit2.Call
import retrofit2.http.*

interface StoryClient {
    @FormUrlEncoded
    @POST("/api/login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @POST("/api/logout")
    fun logout(@Field("Authorization") token: String): Call<LogoutResponse>

    @GET("/api/internship-proposals")
    fun getUsulan(@Header("Authorization") token: String): Call<ListUsulanResponse>

    @GET("/api/internship-agencies")
    fun getInstansi(@Header("Authorization") token:String): Call<ListInstansiResponse>

    @GET("/api/internship-proposals/{id}")
    fun getDetailUsulan(@Header("Authorization") token:String, @Path("id") id: Int): Call<DetailUsulanResponse>
}

