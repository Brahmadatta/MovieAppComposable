package com.example.movieappcomposeexample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieappcomposeexample.ui.theme.MovieAppComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApp {
                MainContent()
            }
        }

    }
}

@Composable
fun MyApp(content : @Composable () -> Unit){
    MovieAppComposeExampleTheme {
        //content()
        Scaffold(topBar = {
            TopAppBar(backgroundColor = Color.Magenta,
            elevation = 5.dp) {
                Text(text = "Movies")
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { Log.d("TAG", "MyApp: Clicked") },
            backgroundColor = Color.Blue) {
                    Text(text = "Heyy", color = Color.White)
            }
        }) {
            content()
        }
    }
}

@Composable
fun MainContent(
    movieList: List<String> = listOf(
        "Avengers End Game",
        "Avatar",
        "BirdBox",
        "KGF",
        "Malleshwari","Avatar",
        "BirdBox",
        "KGF","Malleshwari","Avatar",
        "BirdBox",
        "KGF",
        "Malleshwari","Avatar",
        "BirdBox",
        "KGF",
        "Malleshwari","Avatar",
        "BirdBox",
        "KGF","Malleshwari","Avatar",
        "BirdBox",
        "KGF",
        "Malleshwari","Avatar",
        "BirdBox",
        "KGF",
        "Malleshwari","Avatar",
        "BirdBox",
        "KGF","Malleshwari","Avatar",
        "BirdBox",
        "KGF",
        "Malleshwari",
        "Hera Pheri"
    )
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
                            Log.e("dataa", "MainContent: $it")
                        },
                            contentAlignment = Alignment.Center) {
                            MovieRow(movie = it)
                            //Text(text = it)
                        }
                        }

            }
        }
    }
}

@Composable
fun MovieRow(movie : String){
    
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    elevation = 5.dp) {
        Row(modifier = Modifier.padding(5.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {
            Surface(modifier = Modifier
                .padding(10.dp)
                .size(100.dp),
            elevation = 5.dp,
            shape = RectangleShape) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")
            }
            Text(text = movie)
        }
    }
    
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}