package com.example.acronymapp.api

import com.example.acronymapp.database.AcronymItemModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AcronymApi {

    @GET(ApiReferences.END_POINT)
    suspend fun getAcronymDef(
        @Query("sf") sf: String
    ): Response<List<AcronymItemModel>>
}