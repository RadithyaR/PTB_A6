package com.kpunand.datamodels

import com.google.gson.annotations.SerializedName

data class InternshipsItem(

    @field:SerializedName("end_at")
    val endAt: String? = null,

    @field:SerializedName("supervisor_id")
    val supervisorID: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("start_at")
    val startAt: String? = null,

    @field:SerializedName("nim")
    val nim: String? = null,

    @field:SerializedName("agency")
    val instansi: String? = null,

    @field:SerializedName("title")
    val judul: String? = null,

    @field:SerializedName("supervisor")
    val pembimbing: String? = null,

    @field:SerializedName("status")
    val status: Int? = null,
)
