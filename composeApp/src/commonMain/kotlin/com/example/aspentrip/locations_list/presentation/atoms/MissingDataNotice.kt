package com.example.aspentrip.locations_list.presentation.atoms

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun DrawMissingDataNotice() {
    Box (contentAlignment = Alignment.Center) {
        Text("No data found!")
    }
}