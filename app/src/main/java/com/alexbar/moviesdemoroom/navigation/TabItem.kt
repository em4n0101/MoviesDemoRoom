package com.alexbar.moviesdemoroom.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.alexbar.moviesdemoroom.navigation.Screens

data class TabItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val screen: Screens,
)
