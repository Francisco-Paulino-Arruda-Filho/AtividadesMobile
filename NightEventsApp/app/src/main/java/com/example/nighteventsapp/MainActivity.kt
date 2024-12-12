package com.example.nighteventsapp

import BottomNavigationBar
import DrawerContent
import EventDetailsScreen
import FavoriteScreen
import HomeScreen
import SubscribedEventsScreen
import TopBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nighteventsapp.ui.screens.ProfileScreen
import com.example.nighteventsapp.ui.theme.NightEventsAppTheme
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "home_screen",
        modifier = modifier
    ) {
        composable("home_screen") {
            HomeScreen(navController, context = LocalContext.current)
        }
        composable("events") {
            SubscribedEventsScreen(navController)
        }
        composable("favorites") {
            FavoriteScreen(navController)
        }
        composable("eventDetails/{eventId}") { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId")
            EventDetailsScreen(eventId = eventId)
        }
        composable("profile_screen") {
            ProfileScreen()
        }
    }
}

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val isDarkTheme = remember { mutableStateOf(false) }

            NightEventsAppTheme(darkTheme = isDarkTheme.value) {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    gesturesEnabled = true,
                    drawerContent = {
                        DrawerContent(
                            navController = navController,
                            drawerState = drawerState, // Passa o drawerState aqui
                            onSendNotification = { /* Implementação adicional se necessário */ }
                        )
                    }
                ) {
                    Scaffold(
                        topBar = {
                            TopBar(
                                onThemeToggle = { isDarkTheme.value = !isDarkTheme.value },
                                onOpenDrawer = { scope.launch { drawerState.open() } }
                            )
                        },
                        bottomBar = { BottomNavigationBar(navController) }
                    ) { innerPadding ->
                        AppNavigation(
                            navController = navController,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}


