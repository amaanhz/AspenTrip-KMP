package com.example.aspentrip.main_menu.presentation.atoms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.explore_button
import org.jetbrains.compose.resources.stringResource

@Composable
fun DrawExploreButton(navController: NavController?) {
    Button(onClick = { navController?.navigate("locations") },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(23, 111, 242)
        ),
        modifier = Modifier.fillMaxWidth().height(100.dp).padding(20.dp)
    ) {
        Text(stringResource(Res.string.explore_button),
            style = MaterialTheme.typography.labelMedium
        )
    }
}