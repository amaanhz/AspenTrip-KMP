package com.example.aspentrip.locations_list.presentation.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.hot_deal
import aspentrip.composeapp.generated.resources.main_menu
import aspentrip.composeapp.generated.resources.trending_up
import coil3.compose.AsyncImage
import com.example.aspentrip.locations_list.domain.Location
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun DrawRecommendedItem(loc: Location) {
    Button(onClick = {},
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .width(260.dp)
            .height(220.dp)
            .padding(10.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Column(Modifier.fillMaxSize().background(Color.White)) {
            AsyncImage(
                model = loc.imageURL,
                contentDescription = "Location Image",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(Res.drawable.main_menu),
                modifier = Modifier
                    .height(140.dp)
                    .clip(RoundedCornerShape(30.dp))
            )
            Spacer(Modifier.height(5.dp))
            Text(
                loc.name,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight(750),
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Row (verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 15.dp)){
                Image(painterResource(Res.drawable.trending_up),
                    contentDescription = null
                )
                Text(
                    stringResource(Res.string.hot_deal),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp)
                )
            }
        }
    }
}