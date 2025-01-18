package com.example.requisicoeretrofit.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.requisicoeretrofit.viewModel.PostViewModel

@Composable
fun UserScreen(viewModel: PostViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        isLoading = true
        viewModel.fetchUsers()
        isLoading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 150.dp),
        verticalArrangement = Arrangement.Center,  // Centraliza o conteúdo verticalmente
        horizontalAlignment = Alignment.CenterHorizontally  // Centraliza o conteúdo horizontalmente
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Nome") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                cursorColor = Color(0xFF0077B6),
                focusedIndicatorColor = Color(0xFF0077B6),
                focusedLabelColor = Color(0xFF0077B6)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "E-mail") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                cursorColor = Color(0xFF0077B6),
                focusedIndicatorColor = Color(0xFF0077B6),
                focusedLabelColor = Color(0xFF0077B6)
            )
        )

        Button(
            onClick = {
                isLoading = true
                viewModel.createUser(name, email,
                    onSuccess = {
                        Toast.makeText(context, "Usuário criado com sucesso", Toast.LENGTH_SHORT).show()
                        isLoading = false
                    },
                    onError = {
                        Toast.makeText(context, "Erro ao criar usuário", Toast.LENGTH_SHORT).show()
                        isLoading = false
                    }
                )
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0077B6),
                contentColor = Color.White
            )
        ) {
            Text(text = "Criar Usuário")
        }
        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator()
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.users) { users ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Nome: ${users.name}")
                        Text(
                            text = "Email: ${users.email}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}
