package com.example.acronymapp.database


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Acronyms")
data class AcronymItemModel(
    @SerializedName("lfs")
    val lfs: List<LfModel> = listOf(),
    @SerializedName("sf")
    val sf: String = ""
)