package com.example.pokedex.data

import com.example.pokedex.data.local.PokemonLocalDataSource
import com.example.pokedex.data.remote.PokemonRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultPokemonRepository
@Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val localDataSource: PokemonLocalDataSource
) : PokemonRepository {

    override suspend fun readAll(): List<Pokemon> {
        val pokemons = remoteDataSource.readAll()
        return pokemons
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        refreshLocal()
        return remoteDataSource.observeAll()
    }

    override suspend fun readOne(id: Int): Pokemon {
        return remoteDataSource.readOne(id)
    }

    override suspend fun readOne(name: String): Pokemon {
        return remoteDataSource.readOne(name)
    }

    private fun refreshLocal(){
        GlobalScope.launch(Dispatchers.IO){
            val pokemonRemote = remoteDataSource.readAll()
            localDataSource.insert(pokemonRemote)
        }
    }
}