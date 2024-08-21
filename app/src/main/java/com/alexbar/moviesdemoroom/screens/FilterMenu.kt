package com.alexbar.moviesdemoroom.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alexbar.moviesdemoroom.api.Sort
import com.alexbar.moviesdemoroom.utils.Constants.SORT
import com.alexbar.moviesdemoroom.utils.Constants.SORT_NAME
import com.alexbar.moviesdemoroom.utils.Constants.SORT_VOTE

@Composable
fun FilterMenu(
    onSortOptionSelected: (Sort) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(Sort.NONE) }

    Box(modifier = Modifier.fillMaxWidth()) {
        Row {
            Spacer(modifier = Modifier.weight(1f))
            Text(modifier = Modifier.align(Alignment.CenterVertically), text = SORT)
            IconButton(onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = ""
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(SORT_NAME) },
                onClick = {
                    onSortOptionSelected(Sort.NAME)
                    selectedOption = Sort.NAME
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text(SORT_VOTE) },
                onClick = {
                    onSortOptionSelected(Sort.VOTE_AVERAGE)
                    selectedOption = Sort.VOTE_AVERAGE
                    expanded = false
                }
            )
        }
    }
}
