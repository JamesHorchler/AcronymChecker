package com.example.acronymapp.repository

import com.example.acronymapp.database.AcronymItemModel
import retrofit2.Response

interface Repository {
    suspend fun getAcronym(sf:String): Response<List<AcronymItemModel>>
}