package com.example.pokedex.data.local

import com.example.pokedex.data.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//Usaremos el Dao para modificar la base de datos, pero tendremos que mapear de Pokemon a PokemonEntity
class PokemonLocalDatabase
    @Inject constructor(
        private val dao: PokemonDao
    ):PokemonLocalDataSource {

    override suspend fun insert(pokemons: List<Pokemon>) {
        dao.create(pokemons.toLocal())
    }

    override suspend fun readAll(): List<Pokemon> {
        return dao.readAll().toExternal()
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        return dao.observeAll().map { localPokemons ->
            localPokemons.toExternal()
        }
    }
}