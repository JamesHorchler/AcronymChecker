package com.example.acronymapp.database


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Acronyms")
data class AcronymItemModel(
//    @SerializedName("lfs")
//    val lfs: List<LfModel> = listOf(),
    @PrimaryKey
    @SerializedName("sf")
    val sf: String = ""
)