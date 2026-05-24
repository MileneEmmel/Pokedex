package com.example.pokedex.data.local

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

// expect Construtor pois o Android e o iOS guardam os arquivos SQLite em pastas de sistema diferentes
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase>

@Database(
    entities = [PokemonCacheEntity::class, FavoritePokemonEntity::class],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}
