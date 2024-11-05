package com.example.pokedex.di

import android.content.Context
import androidx.room.Room
import com.example.pokedex.data.DefaultPokemonRepository
import com.example.pokedex.data.PokemonRepository
import com.example.pokedex.data.local.PokemonDao
import com.example.pokedex.data.local.PokemonDataBase
import com.example.pokedex.data.local.PokemonLocalDataSource
import com.example.pokedex.data.local.PokemonLocalDatabase
import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.data.remote.PokemonNetworkDataSource
import com.example.pokedex.data.remote.PokemonRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

private const val POKEAPI_URL = "https://pokeapi.co/"
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providePokeApiService(): PokeApi{
        val service = Retrofit.Builder()
            .baseUrl(POKEAPI_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
            .create(PokeApi::class.java)
        return service
    }
}



