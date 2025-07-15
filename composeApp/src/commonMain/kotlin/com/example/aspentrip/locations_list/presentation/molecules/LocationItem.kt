package com.example.aspentrip.locations_list.presentation.molecules

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.main_menu
import coil3.compose.AsyncImage
import com.example.aspentrip.locations_list.domain.Location
import com.example.aspentrip.locations_list.presentation.atoms.DrawLocationNameLabel
import com.example.aspentrip.locations_list.presentation.atoms.DrawLocationRatingLabel
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrawLocationItem(loc: Location) {
    Button(onClick = {},
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
        .width(260.dp)
        .height(350.dp)
        .padding(10.dp),
        contentPadding = PaddingValues(0.dp)
        ) {
        Box {
            AsyncImage(
                model = loc.imageURL,
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
                Column {
                    DrawLocationNameLabel(loc.name)
                    Spacer(Modifier.height(10.dp))
                    DrawLocationRatingLabel(loc.rating)
                }
            }
        }
    }
}