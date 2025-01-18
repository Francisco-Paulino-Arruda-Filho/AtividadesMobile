package com.example.requisicoeretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.requisicoeretrofit.ui.screens.PostScreen
import com.example.requisicoeretrofit.ui.screens.UserScreen
import com.example.requisicoeretrofit.ui.theme.RequisicoeRetrofitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RequisicoeRetrofitTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Requisições Retrofit") },
                colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0077B6),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color(0xFF0077B6)
            ) {
                BottomNavigationItem(
                    selected = selectTab == 0,
                    onClick = { selectTab = 0 },
                    label = { Text("Usuários") },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Usuários") }
                )
                BottomNavigationItem(
                    selected = selectTab == 1,
                    onClick = { selectTab = 1 },
                    label = { Text("Posts") },
                    icon = { Icon(Icons.Default.List, contentDescription = "Posts") }
                )
            }
        }
    ) { innerPadding ->
        when (selectTab) {
            0 -> UserScreen()
            1 -> PostScreen()
        }
    }
}

