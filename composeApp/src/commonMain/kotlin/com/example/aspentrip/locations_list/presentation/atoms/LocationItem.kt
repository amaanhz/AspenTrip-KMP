package com.example.aspentrip.locations_list.presentation.atoms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.main_menu
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.example.aspentrip.locations_list.domain.Location
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrawLocationItem(loc: Location) {
    Button(onClick = {},
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
        .width(240.dp)
        .height(310.dp)
        .padding(10.dp),
        contentPadding = PaddingValues(0.dp)
        ) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(LocalPlatformContext.current)
                    .data(loc.imageURL)
                    .build(),
                contentDescription = "Location Image",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(Res.drawable.main_menu),
                modifier = Modifier.fillMaxSize()
                    .clip(RoundedCornerShape(30.dp))
            )
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)) {
                Spacer(modifier = Modifier.weight(1.0f))
                Text(loc.name)
                Text(loc.rating.toString())
            }
        }
    }
}