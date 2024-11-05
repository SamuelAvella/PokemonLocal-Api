package com.example.pokedex.di

import android.content.Context
import androidx.room.Insert
import androidx.room.Room
import com.example.pokedex.data.local.PokemonDao
import com.example.pokedex.data.local.PokemonDataBase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): PokemonDataBase { //Application context, para que Hilt busco solo el contexto de la aplicacion y lo use
        val dataBase = Room.databaseBuilder(context,
            PokemonDataBase::class.java,
            "pokemon-db").build()

        return dataBase
    }

    @Provides
    fun providePokemonDao(dataBase: PokemonDataBase): PokemonDao {
        return dataBase.pokemonDao()
    }
}

