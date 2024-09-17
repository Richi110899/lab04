package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Person

class BottomNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función composable BottomNavigationExample para mostrar la UI
            BottomNavigationExample()
        }
    }
}

@Composable
fun BottomNavigationExample() {
    // Estado mutable para mantener el elemento de navegación seleccionado
    var selectedItem by remember { mutableStateOf("Home") }

    // Scaffold proporciona una estructura básica de diseño con una barra de navegación inferior
    Scaffold(
        bottomBar = {
            // Configura la barra de navegación inferior (NavigationBar)
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary, // Color de fondo de la barra de navegación
                contentColor = MaterialTheme.colorScheme.onPrimary // Color del contenido de la barra de navegación
            ) {
                // Elemento de navegación para "Home"
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home", tint = if (selectedItem == "Home") MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onPrimary) },
                    label = { Text("Home", fontSize = 16.sp, textAlign = TextAlign.Center) },
                    selected = selectedItem == "Home",
                    onClick = { selectedItem = "Home" },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.secondary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                        selectedTextColor = MaterialTheme.colorScheme.secondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
                    )
                )
                // Elemento de navegación para "Search"
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Search, contentDescription = "Search", tint = if (selectedItem == "Search") MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onPrimary) },
                    label = { Text("Search", fontSize = 16.sp, textAlign = TextAlign.Center) },
                    selected = selectedItem == "Search",
                    onClick = { selectedItem = "Search" },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.secondary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                        selectedTextColor = MaterialTheme.colorScheme.secondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
                    )
                )
                // Elemento de navegación para "Profile"
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile", tint = if (selectedItem == "Profile") MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onPrimary) },
                    label = { Text("Profile", fontSize = 16.sp, textAlign = TextAlign.Center) },
                    selected = selectedItem == "Profile",
                    onClick = { selectedItem = "Profile" },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.secondary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f),
                        selectedTextColor = MaterialTheme.colorScheme.secondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
                    )
                )
            }
        }
    ) { innerPadding ->
        // Contenido principal de la aplicación ajustado por el padding de la barra inferior
        Box(
            modifier = Modifier
                .padding(innerPadding) // Aplica padding para evitar que el contenido quede cubierto por la barra inferior
                .fillMaxSize()
        ) {
            // Muestra el contenido basado en el elemento de navegación seleccionado
            when (selectedItem) {
                "Home" -> Text("Home Screen", modifier = Modifier.padding(16.dp), fontSize = 20.sp, textAlign = TextAlign.Center)
                "Search" -> Text("Search Screen", modifier = Modifier.padding(16.dp), fontSize = 20.sp, textAlign = TextAlign.Center)
                "Profile" -> Text("Profile Screen", modifier = Modifier.padding(16.dp), fontSize = 20.sp, textAlign = TextAlign.Center)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    // Previsualiza la interfaz de usuario de BottomNavigationExample
    BottomNavigationExample()
}
