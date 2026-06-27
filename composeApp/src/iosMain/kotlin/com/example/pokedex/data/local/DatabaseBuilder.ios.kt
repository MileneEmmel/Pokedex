package com.example.pokedex.data.local

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/Documents/pokedex.db"
    return Room.databaseBuilder<AppDatabase>(
        name    = dbFilePath,
        factory = { AppDatabase::class.instantiateImpl() } // Exigência gerada automaticamente pelo Room KMP
    )
        .addMigrations(AppDatabase.MIGRATION_1_2)
}