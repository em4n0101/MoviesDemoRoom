package com.alexbar.moviesdemoroom.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alexbar.moviesroomdemo.utils.Constants.TAB_FAVORITES
import com.alexbar.moviesroomdemo.utils.Constants.TAB_TRENDING

@Composable
fun BottomNavigationBar(navController: NavController) {
    val tabItems = listOf(
        TabItem(
            title = TAB_TRENDING,
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
            screen = Screens.TrendingMoviesScreen
        ),
        TabItem(
            title = TAB_FAVORITES,
            selectedIcon = Icons.Filled.Star,
            unselectedIcon = Icons.Outlined.Star,
            screen = Screens.FavoritesMoviesScreen
        ),
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        tabItems.forEach { item ->
            NavigationBarItem(
                icon = { Icon(
                    imageVector = if (currentRoute ==  item.screen.route) {
                        item.selectedIcon
                    } else {
                        item.unselectedIcon
                    },
                    contentDescription = item.title
                ) },
                label = { Text(item.title) },
                selected = currentRoute ==  item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}