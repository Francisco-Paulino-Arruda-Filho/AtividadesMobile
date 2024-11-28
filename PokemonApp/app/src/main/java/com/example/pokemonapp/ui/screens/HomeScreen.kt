package com.example.pokemonapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.pokemonapp.models.Pokemon
import com.example.pokemonapp.models.pokemonList
import com.example.pokemonapp.ui.components.PokemonListItem

@Composable
fun HomeScreen(onPokemonSelected: (Pokemon) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredPokemon = remember(searchQuery) {
        pokemonList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }
    Column {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Pesquisar") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            items(filteredPokemon) { pokemon ->
                PokemonListItem(pokemon = pokemon, onPokemonSelected = onPokemonSelected) // Aqui está a correção
            }
        }
    }
}
