package com.example.pokemonapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemonapp.ui.screens.PokemonScreen
import com.example.pokemonapp.ui.screens.HomeScreen
import com.example.pokemonapp.models.pokemonList

@ExperimentalMaterial3Api
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        // Tela inicial com a lista de Pokémon
        composable("home") {
            HomeScreen(onPokemonSelected = { pokemon ->
                // Navega para a tela de detalhes do Pokémon
                navController.navigate("pokemon/${pokemon.name}")
            })
        }
        // Tela de detalhes do Pokémon
        composable("pokemon/{pokemonName}") { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName")
            val selectedPokemon = pokemonList.firstOrNull { it.name == pokemonName }
            // Verifica se o Pokémon foi encontrado antes de renderizar a tela
            selectedPokemon?.let { pokemon ->
                PokemonScreen(pokemon = pokemon)
            }
        }
    }
}
