package com.example.acronymapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//@Dao
//interface AcronymDao {
//
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertAcronym(acronym: AcronymItemModel)
//
//    @Query("SELECT EXISTS(SELECT * FROM acronyms WHERE sf = :sf)")
//    fun getAcronym(sf: String): String
//}