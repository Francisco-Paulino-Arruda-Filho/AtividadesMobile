package com.example.nighteventsapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.nighteventsapp.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun ProfileScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Adiciona rolagem vertical
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagem de Perfil com fundo
        Box(
            modifier = Modifier
                .size(130.dp)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_image_placeholder),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(120.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "Foto de perfil de Francisco Paulino Arruda Filho",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nome do Perfil
        Text(
            text = "Francisco Paulino Arruda Filho",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        // Descrição
        Text(
            text = "Desenvolvedor de software com 2 anos de experiência.",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Emprego Atual
        Text(
            text = "Emprego Atual: Engenheira de Software na TechX",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Seções dinâmicas
        DynamicSection(
            title = "Educação",
            items = listOf("Bacharelado em Engenharia de Software - UFC"),
            backgroundColor = MaterialTheme.colorScheme.surface
        )
        DynamicSection(
            title = "Habilidades",
            items = listOf(
                "Java", "Git", "GitHub", "React", "TS", "JS",
                "Ionic", "PHP", "Firebase", "MySQL", "PSQL"
            ),
            backgroundColor = MaterialTheme.colorScheme.surface
        )
        DynamicSection(
            title = "Projetos",
            items = listOf(
                "Site museu de Quixadá - Colaborador",
                "Sustainow - Colaborador",
                "SGEC - Colaborador"
            ),
            backgroundColor = MaterialTheme.colorScheme.surfaceVariant
        )
        DynamicSection(
            title = "Experiências",
            items = listOf(
                "Analista de Sistemas - Empresa A",
                "Desenvolvedora Júnior - Empresa B",
                "Estagiário - Empresa C"
            ),
            backgroundColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

@Composable
fun DynamicSection(title: String, items: List<String>, backgroundColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                color = backgroundColor,
                shape = MaterialTheme.shapes.medium
            )
            .padding(16.dp)
    ) {
        // Título da seção
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Itens da lista
        items.forEach { item ->
            Text(
                text = item,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}