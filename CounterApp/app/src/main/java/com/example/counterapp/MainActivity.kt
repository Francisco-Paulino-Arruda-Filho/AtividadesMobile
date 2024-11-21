package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterApp()
                }
            }
        }
    }
}

@Composable
fun CounterApp() {
    // Estado para armazenar o resultado das operações
    var result by remember { mutableStateOf(0.0) }
    // Estado para armazenar o valor de entrada do usuário
    var input by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Exibe o resultado atual
        Text(
            text = "Resultado: $result",
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )

        // Campo de entrada para número, onde o usuário digita um valor
        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Digite um número") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Linha com os botões de incremento e decremento
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    result += input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE), // Roxo
                    contentColor = Color.White // Texto branco
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("Incrementar")
            }
            Button(
                onClick = {
                    result -= input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary, // Cor terciária
                    contentColor = MaterialTheme.colorScheme.onTertiary // Cor do texto
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("Decrementar")
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Button(
                onClick = {
                    result *= input.toDoubleOrNull() ?: 1.0
                    input = ""
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3), // Azul
                    contentColor = Color.Yellow // Texto amarelo
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("Multiplicar")
            }
            Button(
                onClick = {
                    val value = input.toDoubleOrNull() ?: 1.0
                    if (value != 0.0) {
                        result /= value
                    }
                    input = ""
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50), // Verde
                    contentColor = Color.Black // Texto preto
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("Dividir")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                result = 0.0
                input = ""
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary, // Cor secundária
                contentColor = MaterialTheme.colorScheme.onSecondary // Cor do texto
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    CounterAppTheme {
        CounterApp()
    }
}
