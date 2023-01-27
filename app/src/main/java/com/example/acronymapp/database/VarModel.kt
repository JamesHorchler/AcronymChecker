package com.example.acronymapp.database


import com.google.gson.annotations.SerializedName

data class VarModel(
    @SerializedName("freq")
    val freq: Int = 0,
    @SerializedName("lf")
    val lf: String = "",
    @SerializedName("since")
    val since: Int = 0
)