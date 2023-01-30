package com.example.acronymapp.repository

import com.example.acronymapp.api.AcronymApi
import com.example.acronymapp.database.AcronymDao
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val acronymApi: AcronymApi,
    private val acronymDao: AcronymDao
) {
     suspend fun getAcronymDefinition() = acronymApi.getAcronymDef()
}