package com.kpunand.retrofit

import com.kpunand.response.LoginResponse
import com.kpunand.response.LogoutResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("api/login")
    fun login (
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @POST("api/logout")
    fun logout(@Header("Authorization") token: String) : Call<LogoutResponse>
}