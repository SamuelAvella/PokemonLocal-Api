package com.example.pokedex.data

import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    suspend fun readAll(): List<Pokemon>

    fun observeAll(): Flow<List<Pokemon>>

    suspend fun readOne(id:Int):Pokemon

    suspend fun readOne(name:String): Pokemon

}