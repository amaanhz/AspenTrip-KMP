package com.example.aspentrip.main_menu.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.main_menu
import aspentrip.composeapp.generated.resources.title
import com.example.aspentrip.main_menu.presentation.atoms.DrawExploreButton
import com.example.aspentrip.main_menu.presentation.atoms.DrawMainTitle
import com.example.aspentrip.main_menu.presentation.atoms.DrawSubTitle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun MainMenu(navController: NavController?) {
    Image(painterResource(Res.drawable.main_menu),
        contentDescription = "",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop)
    Column(
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DrawMainTitle(stringResource(Res.string.title))
        Spacer(Modifier.weight(1.0f))
        DrawSubTitle()
        DrawExploreButton(navController)
        Spacer(Modifier.height(30.dp))
    }
}

