package com.kpunand.datamodels

import com.google.gson.annotations.SerializedName

class Authorisation {
    @field:SerializedName("type")
    val type: String? = null

    @field:SerializedName("token")
    val token: String? = null
}