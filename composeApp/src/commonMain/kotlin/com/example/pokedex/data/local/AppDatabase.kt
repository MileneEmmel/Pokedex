package com.example.pokedex.data.local

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// expect Construtor pois o Android e o iOS guardam os arquivos SQLite em pastas de sistema diferentes
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase>

@Database(
    entities = [PokemonCacheEntity::class, FavoritePokemonEntity::class],
    version = 2
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao

    companion object {
        // Migração V1 -> V2: adiciona colunas de geolocalização e foto aos favoritos
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE favorite_pokemon ADD COLUMN latitude REAL DEFAULT NULL")
                database.execSQL("ALTER TABLE favorite_pokemon ADD COLUMN longitude REAL DEFAULT NULL")
                database.execSQL("ALTER TABLE favorite_pokemon ADD COLUMN photoPath TEXT DEFAULT NULL")
            }
        }
    }
}
