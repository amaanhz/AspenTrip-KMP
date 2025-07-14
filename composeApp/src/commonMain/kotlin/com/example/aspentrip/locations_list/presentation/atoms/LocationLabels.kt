package com.example.aspentrip.locations_list.presentation.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.star
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrawLocationNameLabel(name: String) {
    Box(Modifier
        .clip(RoundedCornerShape(30.dp))
        .background(color = Color.DarkGray)) {
        Text(name,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Composable
fun DrawLocationRatingLabel(rating: Double) {
    Box(Modifier
        .clip(RoundedCornerShape(30.dp))
        .background(color = Color.DarkGray)) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)) {
            Image(painterResource(Res.drawable.star),
                contentDescription = null,
                modifier = Modifier.size(16.dp))
            Spacer(Modifier.width(5.dp))
            Text(
                rating.toString(),
                style = MaterialTheme.typography.labelSmall,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}