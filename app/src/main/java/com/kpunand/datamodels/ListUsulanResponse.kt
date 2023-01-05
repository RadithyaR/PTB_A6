package com.kpunand.datamodels

import com.google.gson.annotations.SerializedName

data class ListUsulanResponse(

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("proposals")
    val proposals: List<ProposalsItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null
)