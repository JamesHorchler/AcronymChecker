package com.example.acronymapp.repository

import com.example.acronymapp.api.AcronymApi
import com.example.acronymapp.database.AcronymDao
import com.example.acronymapp.database.AcronymItemModel
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val acronymApi: AcronymApi,
   // private val acronymDao: AcronymDao
): Repository {
    override suspend fun getAcronym(): Response<AcronymItemModel> =
         acronymApi.getAcronymDef()
}