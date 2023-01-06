package com.kpunand.retrofit.response

import com.google.gson.annotations.SerializedName

data class LaporanResponse(

    @field:SerializedName("internships")
    val internships: List<InternshipsItem?>? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("status")
    val status: String? = null
)
