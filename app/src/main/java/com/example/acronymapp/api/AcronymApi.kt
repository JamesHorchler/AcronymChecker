package com.example.acronymapp.api

import com.example.acronymapp.database.AcronymItemModel
import retrofit2.Response
import retrofit2.http.GET

interface AcronymApi {

    @GET(ApiReferences.END_POINT)
    suspend fun getAcronymDef(): Response<AcronymItemModel>
}