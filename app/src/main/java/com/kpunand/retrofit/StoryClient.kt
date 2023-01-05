package com.kpunand.retrofit

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
    fun logout(@Field("Authorisation") token: String): retrofit2.Call<LogoutResponse>

    @GET("/api/internships")
    fun getMahasiswa(@Header("Authorization") token: String): Call<ListMahasiswaKPResponse>
}

