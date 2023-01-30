package com.example.acronymapp.database


import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "Acronyms")
data class AcronymItemModel(
//    @PrimaryKey
    @SerializedName("sf")
    val sf: String = "",
    @SerializedName("lfs")
//    @Ignore
    val lfs: List<LfModel> = listOf()
) {


}