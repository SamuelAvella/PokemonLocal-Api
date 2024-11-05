package com.example.pokedex.data.local

import com.example.pokedex.data.Pokemon

fun Pokemon.toLocal():PokemonEntity{
    return PokemonEntity(
        id = this.id,
        name = this.name,
        height = this.height,
        weigth = this.weigth
    )
}

fun List<Pokemon>.toLocal():List<PokemonEntity>{
    return this.map { p -> p.toLocal() }
}

fun PokemonEntity.toExternal():Pokemon{
    return Pokemon(
        id = this.id,
        name = this.name,
        height = this.height,
        weigth = this.weigth
    )
}

fun List<PokemonEntity>.toExternal() = map {it.toExternal()}