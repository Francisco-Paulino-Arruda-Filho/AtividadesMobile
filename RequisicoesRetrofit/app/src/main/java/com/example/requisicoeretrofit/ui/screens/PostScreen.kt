package com.example.requisicoeretrofit.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.requisicoeretrofit.data.models.Post
import com.example.requisicoeretrofit.viewModel.PostViewModel

@Composable
fun PostScreen(viewModel: PostViewModel = viewModel()) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var editPost by remember { mutableStateOf<Post?>(null) }
    var context = LocalContext.current


    LaunchedEffect(Unit) {
        isLoading = true
        viewModel.fetchPosts()
        isLoading = false
    }

    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 150.dp)) {
        TextField(
            value = title,
            onValueChange = {title = it},
            label = { Text(text = "Título") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                cursorColor = Color(0xFF0077B6),
                focusedIndicatorColor = Color(0xFF0077B6),
                focusedLabelColor = Color(0xFF0077B6)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = content,
            onValueChange = {content = it},
            label = { Text(text = "Conteúdo") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                cursorColor = Color(0xFF0077B6),
                focusedIndicatorColor = Color(0xFF0077B6),
                focusedLabelColor = Color(0xFF0077B6)
            )
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                isLoading = true
                viewModel.createPost(title, content, onSuccess = {
                    Toast.makeText(context, "Post criado com sucesso!", Toast.LENGTH_SHORT).show()
                    isLoading = false
                },
                    onError = {
                        Toast.makeText(context, "Erro ao criar um Post", Toast.LENGTH_SHORT).show()
                        isLoading = false
                    }
                )
                title = ""
                content = ""
            }, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0077B6),
                contentColor = Color.White
            )
        ) {
            Text(text = "Criar Post") // Adiciona o texto ao botão
        }
        Spacer(modifier = Modifier.height(16.dp))

        if(isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            LazyColumn {
                items(viewModel.post) {
                    item: Post ->
                    PostItem(post = item, onDelete = {viewModel.deletePost(it)}, onEdit = {editPost = it})
                }
            }
        }
    }

    if(editPost != null) {
        AlertDialog(
            onDismissRequest = {editPost = null},
            title = { Text("Editar") },
            text = {
                Column {
                    TextField(value = editPost!!.title,
                        onValueChange = {
                            newTitle -> editPost =
                            editPost!!.copy(title = newTitle)
                        }, label = { Text(text = "Título") })
                }
                Spacer(modifier = Modifier.height(8.dp))

                TextField(value = editPost!!.content,
                    onValueChange = {
                            newContent -> editPost =
                        editPost!!.copy(title = newContent)
                    }, label = { Text(text = "Conteúdo") })
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.updatePost(editPost!!.id, editPost!!.title, editPost!!.content)
                        editPost = null
                    }
                ) {
                    Text(text = "Salvar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {editPost = null}
                ) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}