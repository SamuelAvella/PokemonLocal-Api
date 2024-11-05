package com.example.pokedex.data.remote

import com.example.pokedex.data.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {

    suspend fun readAll():List<Pokemon>
    suspend fun readOne(id:Int):Pokemon
    fun observeAll(): Flow<List<Pokemon>>
    suspend fun readOne(name:String): Pokemon
}