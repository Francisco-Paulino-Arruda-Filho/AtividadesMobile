package com.example.startservice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ServiceControlScreen(
    onStartClick: () -> Unit,
    onstopClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = onStartClick, modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Iniciar Serviço"
                )
            }
            Button(onClick =  onstopClick, modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Terminar serviço"
                )
            }
        }
    }
}

@Composable
@Preview
fun ver() {
    ServiceControlScreen(onStartClick = {}, onstopClick = {})
}
