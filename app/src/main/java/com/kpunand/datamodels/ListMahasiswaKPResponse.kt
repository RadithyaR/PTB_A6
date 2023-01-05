package com.kpunand.datamodels

import com.google.gson.annotations.SerializedName

data class ListMahasiswaKPResponse(

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("internships")
    val internships: List<InternshipsItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null
)