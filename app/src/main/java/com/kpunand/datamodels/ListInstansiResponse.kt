package com.kpunand.datamodels

import com.google.gson.annotations.SerializedName

data class ListInstansiResponse(

    @field:SerializedName("companies")
    val companies: List<CompaniesItem?>? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("status")
    val status: String? = null
)

