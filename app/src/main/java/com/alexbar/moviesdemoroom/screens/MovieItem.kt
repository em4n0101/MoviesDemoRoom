package com.alexbar.moviesdemoroom.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.alexbar.moviesdemoroom.api.Movie
import com.alexbar.moviesdemoroom.utils.Constants.API_BASE_URL_IMAGES
import com.alexbar.moviesdemoroom.viewmodel.MoviesViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MovieItem(
    movie: Movie,
    viewModel: MoviesViewModel,
    isFavorite: Boolean
) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberImagePainter(data = "$API_BASE_URL_IMAGES${movie.poster_path}"),
            contentDescription = null,
            modifier = Modifier.size(100.dp, 160.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    RatingBar(
                        rating = movie.vote_average,
                        stars = 10
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    modifier = Modifier.size(60.dp),
                    onClick = {
                        if (viewModel.favoriteMoviesStateFlow.value.contains(movie))
                            viewModel.deleteMovie(movie)
                        else
                            viewModel.insertMovie(movie)
                    }) {
                    Icon(
                        modifier = Modifier
                            .size(55.dp)
                            .fillMaxSize(),
                        imageVector = if (isFavorite)
                            Icons.Filled.Favorite
                        else
                            Icons.Outlined.FavoriteBorder,
                        contentDescription = "",
                        tint = Color.Blue
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = movie.overview,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 4
            )
        }

    }
}