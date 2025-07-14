package com.example.aspentrip

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aspentrip.locations_list.presentation.LocationsList
import com.example.aspentrip.main_menu.presentation.MainMenu
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "main") {
        composable("main") {
            MainMenu(navController)
        }

        composable("locations") {
            LocationsList(navController)
        }
    }
}