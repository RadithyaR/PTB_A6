package com.kpunand.datamodels

import com.google.gson.annotations.SerializedName

data class MahasiswaItem(

    @field:SerializedName("birthday")
    val birthday: String? = null,

    @field:SerializedName("address")
    val address: Any? = null,

    @field:SerializedName("gender")
    val gender: Int? = null,

    @field:SerializedName("year")
    val year: Int? = null,

    @field:SerializedName("department_id")
    val departmentId: Int? = null,

    @field:SerializedName("photo")
    val photo: Any? = null,

    @field:SerializedName("created_at")
    val createdAt: Any? = null,

    @field:SerializedName("religion")
    val religion: Any? = null,

    @field:SerializedName("nik")
    val nik: String? = null,

    @field:SerializedName("marital_status")
    val maritalStatus: Any? = null,

    @field:SerializedName("nim")
    val nim: String? = null,

    @field:SerializedName("birthplace")
    val birthplace: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: Any? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("pivot")
    val pivot: Pivot? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("status")
    val status: Int? = null
)

data class Pivot(

    @field:SerializedName("proposal_id")
    val proposalId: Int? = null,

    @field:SerializedName("student_id")
    val studentId: Int? = null
)
