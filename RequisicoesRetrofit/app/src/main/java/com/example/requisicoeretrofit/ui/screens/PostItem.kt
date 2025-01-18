package com.example.requisicoeretrofit.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.requisicoeretrofit.data.models.Post

@Composable
fun PostItem(post: Post, onDelete: (Int) -> Unit, onEdit:(Post) -> Unit) {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = post.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(4.dp))

            Text(text = post.content, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Button(
                    onClick = {showDialog = true},
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error),
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text("Deletar")
                }

                Button(onClick = {onEdit(post)}) {
                    Text(text = "Editar")
                }
            }
        }

        if(showDialog) {
            AlertDialog(
                onDismissRequest = {showDialog = false},
                title = {
                    Text(text = "Confimar Exclusão")
                },
                text = {
                    Text(text = "Tem certeza que deseja deletar esse post?")
                },
                confirmButton = {
                    TextButton(onClick = {
                        onDelete(post.id)
                        showDialog = false
                    }) {
                        Text(text = "Sim")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(text = "Cancelar")
                    }
                }
            )
        }
    }
}