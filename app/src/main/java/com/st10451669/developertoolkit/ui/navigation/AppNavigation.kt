package com.st10451669.developertoolkit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.st10451669.developertoolkit.uiscreens.DeviceInfoScreen
import com.st10451669.developertoolkit.uiscreens.NotesScreen
import com.st10451669.developertoolkit.uiscreens.LinksScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            Row {
                Button(onClick = { navController.navigate("device") }) {
                    Text("Device")
                }
                Button(onClick = { navController.navigate("notes") }) {
                    Text("Notes")
                }
                Button(onClick = { navController.navigate("links") }) {
                    Text("Links")
                }
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "device",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("device") { DeviceInfoScreen() }
            composable("notes") { NotesScreen() }
            composable("links") { LinksScreen() }
        }
    }
}