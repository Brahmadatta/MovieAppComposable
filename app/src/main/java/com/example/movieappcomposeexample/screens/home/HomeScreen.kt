package com.example.movieappcomposeexample.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappcomposeexample.model.Movie
import com.example.movieappcomposeexample.model.getMovies
import com.example.movieappcomposeexample.navigation.MovieScreens
import com.example.movieappcomposeexample.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){

    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.LightGray,
            elevation = 5.dp) {
            Text(text = "Movies")
        }
    },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { Log.d("TAG", "MyApp: Clicked") },
//                backgroundColor = Color.Blue) {
//                Text(text = "Heyy", color = Color.White)
//            }
//        }
    )
    {
        MainContent(navController = navController)
    }

}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
){
    Column(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()) {
        LazyColumn(){
            items(items = movieList){
                Surface(modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                ) {
                    Box(modifier = Modifier
                        .padding(15.dp)
                        .clickable {
                            //Log.e("dataa", "MainContent: $it")
                        },
                        contentAlignment = Alignment.Center) {
                        MovieRow(movie = it) { movie ->
                            //Log.d("TAG", "MainContent: $movie")
                            navController.navigate(route = MovieScreens.DetailScreen.name+"/$movie")
                        }
                        //Text(text = it)
                    }
                }

            }
        }
    }
}