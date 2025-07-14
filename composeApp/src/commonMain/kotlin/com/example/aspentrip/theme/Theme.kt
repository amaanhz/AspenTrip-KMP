package com.example.aspentrip.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import aspentrip.composeapp.generated.resources.Montserrat
import aspentrip.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

private val lightScheme = lightColorScheme(
    primaryContainer = asp_primary_container_color,
    onPrimaryContainer = asp_primary_on_container_color,
    secondaryContainer = asp_primary_container_color,
    onSecondaryContainer = asp_secondary_on_container_color,
    background = asp_bg_color
)

@Composable
fun AspenTripTheme (
    content: @Composable() () -> Unit
) {
    val montserrat = FontFamily(Font(Res.font.Montserrat))

    MaterialTheme(
        colorScheme = lightScheme,
        shapes = MaterialTheme.shapes,
        typography = Typography(
            headlineSmall = TextStyle(
                fontFamily = montserrat,
                fontWeight = FontWeight(500),
                fontSize = 25.sp
            ),
            headlineMedium = TextStyle(
                fontFamily = montserrat,
                fontWeight = FontWeight(650),
                fontSize = 30.sp
            ),
            headlineLarge = TextStyle(
                fontFamily = montserrat,
                fontWeight = FontWeight(800),
                fontSize = 40.sp
            ),
            labelSmall = TextStyle(
                fontFamily = montserrat,
                fontSize = 15.sp
            ),
            labelMedium = TextStyle(
                fontFamily = montserrat,
                fontSize = 20.sp,
                fontWeight = FontWeight(750)
            )
        ),
        content = {
            Surface(content = content)
        }
    )
}