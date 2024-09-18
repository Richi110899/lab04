package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

class Scaffold : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldExample() // Configura el contenido de la actividad con el ejemplo de Scaffold
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    var presses by remember { mutableStateOf(0) } // Estado para contar clics del botón flotante

    Scaffold(
        topBar = { // Barra superior de la interfaz
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black, // Color de fondo de la barra
                    titleContentColor = Color.White, // Color del texto del título
                ),
                title = {
                    Text(
                        "Top app bar", // Título de la barra superior
                        fontSize = 20.sp, // Tamaño del texto
                        fontWeight = FontWeight.Bold // Grosor del texto
                    )
                }
            )
        },
        bottomBar = { // Barra inferior de la interfaz
            BottomAppBar(
                containerColor = Color.DarkGray, // Color de fondo de la barra
                contentColor = Color.White, // Color del texto en la barra
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(), // Asegura que el texto ocupe el ancho completo de la barra
                    textAlign = TextAlign.Center, // Centra el texto
                    text = "Bottom app bar", // Texto de la barra inferior
                    fontSize = 18.sp, // Tamaño del texto
                    fontWeight = FontWeight.Bold // Grosor del texto
                )
            }
        },
        floatingActionButton = { // Botón flotante de acción
            FloatingActionButton(
                onClick = { presses++ },
                containerColor = Color.Magenta // Color de fondo del botón flotante
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White) // Ícono del botón flotante
            }
        }
    ) { innerPadding -> // Contenido principal, ajustado por el relleno interno del Scaffold
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(), // Asegura que el contenido ocupe el tamaño completo
            verticalArrangement = Arrangement.Center, // Centra verticalmente el contenido
            horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente el contenido
        ) {
            Text(
                modifier = Modifier.padding(16.dp), // Padding alrededor del texto
                text = "Este es un curso de Programación móvil en Tecsup 2024",
                fontSize = 20.sp, // Tamaño del texto
                fontWeight = FontWeight.Normal, // Grosor del texto
                color = Color.Black, // Color del texto
                textAlign = TextAlign.Center // Alineación del texto
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    ScaffoldExample() // Vista previa del diseño del Scaffold_B
}
