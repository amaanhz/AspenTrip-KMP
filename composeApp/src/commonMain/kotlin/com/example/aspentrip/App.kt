package com.example.aspentrip

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aspentrip.locations_list.di.locationsModule
import com.example.aspentrip.locations_list.presentation.LocationsListRoot
import com.example.aspentrip.main_menu.presentation.MainMenu
import com.example.aspentrip.theme.AspenTripTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication


@Composable
@Preview
fun App() {
    KoinApplication(
        application = {
            modules(locationsModule)
        }
    ) {
        val navController = rememberNavController()
        AspenTripTheme {
            NavHost(navController, startDestination = "main") {
                composable("main") {
                    MainMenu(navController)
                }

                composable("locations") {
                    LocationsListRoot(navController)
                }
            }
        }
    }
}