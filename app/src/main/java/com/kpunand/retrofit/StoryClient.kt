package com.kpunand.retrofit

import com.kpunand.datamodels.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface StoryClient {
    @FormUrlEncoded
    @POST("/api/login")
    fun login(@Field("username") username: String, @Field("password") password:String): retrofit2.Call<LoginResponse>;

}