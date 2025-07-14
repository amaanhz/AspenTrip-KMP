package com.example.aspentrip.locations_list.presentation.atoms

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DrawTabSelectButton(tabName: String,
                        tabIndex: Int,
                        thisSelected: Boolean,
                        onSelect: (index: Int) -> Unit
) {

    Button(onClick = {onSelect(tabIndex)},
        modifier = Modifier
            .scale(if (thisSelected) 1.1f else 1.0f )
            .padding(horizontal = if (thisSelected) 8.dp else 2.dp
                , vertical = 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor =
                if (thisSelected)
                    Color(23, 111, 242).copy(
                        alpha = 0.2f
                    )
                else Color.LightGray.copy(
                    alpha = 0.2f
                )
        )
    ) {
        Text(tabName,
            color = if (thisSelected) MaterialTheme.colorScheme.onSecondaryContainer
            else MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.labelSmall,
            fontWeight =
                if (thisSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}