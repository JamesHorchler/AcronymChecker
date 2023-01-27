package com.example.acronymapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AcronymItemModel::class],
    version = 1,
    exportSchema = false
)
abstract class AcronymDatabase: RoomDatabase() {
    abstract fun getDao(): AcronymDao
}