package com.example.crudapp2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crudapp.UserViewModel


class MainActivity : ComponentActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserApp(viewModel = viewModel) // Carregando a função UserApp no Compose
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UserApp(viewModel: UserViewModel) {
    val usuarios by viewModel.users.observeAsState(emptyList())
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var usuarioEditando by remember { mutableStateOf<User?>(null) }
    var mensagemErro by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Gerenciamento de Usuários") },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Título da seção
            Text(
                if (usuarioEditando == null) "Adicionar um novo Usuário" else "Editar Usuário",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Campo de nome
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text(text = "Nome") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo de idade
            OutlinedTextField(
                value = idade,
                onValueChange = { idade = it },
                label = { Text(text = "Idade") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão para salvar
            Button(
                onClick = {
                    try {
                        if (nome.isNotEmpty() && idade.isNotEmpty()) {
                            val idadeInt = idade.toInt()
                            if (usuarioEditando == null) {
                                viewModel.addUser(User(name = nome, age = idadeInt))
                            } else {
                                viewModel.updateUser(usuarioEditando!!.copy(name = nome, age = idadeInt))
                                usuarioEditando = null
                            }
                            nome = ""
                            idade = ""
                            mensagemErro = null
                        }
                    } catch (e: NumberFormatException) {
                        mensagemErro = "Idade inválida"
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(if (usuarioEditando == null) "Adicionar usuário" else "Salvar alterações")
            }

            // Mensagem de erro
            mensagemErro?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    it,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Gray, thickness = 1.dp)

            // Seção de exibição de usuários registrados
            Text(
                text = "Usuários Registrados",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(usuarios) { usuario ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Nome: ${usuario.name}",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                                Text(
                                    text = "Idade: ${usuario.age}",
                                    fontSize = 14.sp,
                                    color = Color.Gray
                                )
                            }
                            Button(
                                onClick = { usuarioEditando = usuario },
                                modifier = Modifier.padding(end = 8.dp)
                            ) {
                                Text("Editar")
                            }
                            Button(
                                onClick = { viewModel.deleteUser(usuario) }
                            ) {
                                Text("Excluir")
                            }
                        }
                    }
                }
            }
        }
    }
}
