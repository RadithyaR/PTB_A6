package com.kpunand.datamodels

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("authorisation")
    val authorisation: Authorisation? = null,

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("email")
    val email: User? = null,

    @field:SerializedName("status")
    val status: String? = null

)


