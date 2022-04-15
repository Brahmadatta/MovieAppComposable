package com.example.movieappcomposeexample.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.movieappcomposeexample.model.Movie
import com.example.movieappcomposeexample.model.getMovies

@Preview
@Composable
fun MovieRow(movie : Movie = getMovies()[0], onItemClick : (String) -> Unit = {}){

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
            onItemClick(movie.id)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 5.dp) {
        Row(modifier = Modifier.padding(5.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Surface(modifier = Modifier
                .padding(10.dp)
                .size(100.dp),
                elevation = 5.dp,
                shape = RectangleShape
            ) {
                //Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")
                Image(painter = rememberImagePainter(data = movie.images[0], builder = {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }), contentDescription = "Movie Poster")
            }
            Column(modifier = Modifier.padding(5.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director : ${movie.director}", style = MaterialTheme.typography.caption)
                Text(text = "Released : ${movie.year}", style = MaterialTheme.typography.caption)
            }
        }
    }

}