package com.example.pokedex.data.remote

import com.example.pokedex.data.Pokemon
import com.example.pokedex.data.local.PokemonEntity
import kotlinx.coroutines.flow.Flow
import okio.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonNetworkDataSource
    @Inject constructor(
        private val pokemonApi: PokeApi
    ) : PokemonRemoteDataSource {

    override suspend fun readAll(): List<Pokemon> {
        try {
            val pokemons = pokemonApi.readAll()
            return pokemons
        } catch (ex:IOException){
            return listOf(Pokemon)
        }

    }

    override suspend fun readOne(id: Int): Pokemon {
        TODO("Not yet implemented")
    }

    override suspend fun readOne(name: String): Pokemon {
        TODO("Not yet implemented")
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        TODO("Not yet implemented")
    }
}