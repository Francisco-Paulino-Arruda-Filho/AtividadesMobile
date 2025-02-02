import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material3.Icon


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        // Lista de itens com rotas, rótulos e ícones
        val items = listOf(
            Triple("home_screen", "Home", Icons.Default.Home),
            Triple("events", "Inscritos", Icons.Default.Event),
            Triple("favorites", "Favoritos", Icons.Default.Favorite)
        )
        items.forEach { (route, label, icon) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) }, // Ícone específico para cada item
                label = { Text(label) },
                selected = false, // Atualize a lógica de seleção, se necessário
                onClick = { navController.navigate(route) }
            )
        }
    }
}
