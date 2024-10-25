package com.example.natureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.layout.ContentScale

data class Place(val name: String, val description: String, val imageUrl: String)

val places = listOf(
    Place(
        name = "Monteverde Cloud Forest, Costa Rica",
        description = "Una impresionante reserva de bosque nuboso con diversa vida silvestre.",
        imageUrl = "https://images.squarespace-cdn.com/content/v1/596b2969d2b85786e6892853/1681598178279-HWV253A86KHBGCWMBLZA/0K3A0235_1.jpg?format=1500w"
    ),
    Place(
        name = "Banff National Park, Canada",
        description = "Un hermoso parque nacional con majestuosas montañas y lagos turquesas.",
        imageUrl = "https://www.discover-the-world.com/app/uploads/2018/05/canada-alberta-moraine-lake-viewpoint-trav-alb.jpg"
    ),
    Place(
        name = "Plitvice Lakes National Park, Croatia",
        description = "Famoso por sus lagos y cascada.",
        imageUrl = "https://www.somtoseeks.com/wp-content/uploads/2023/07/Plitvice-National-Park-Croatia-.jpg"
    ),
    Place(
        name = "Grand Canyon, USA",
        description = "Un vasto e icónico cañón con impresionantes formaciones geológicas.",
        imageUrl = "https://www.nps.gov/grca/planyourvisit/images/mather-point-2021.jpg?maxwidth=1300&autorotate=false"
    ),
    Place(
        name = "Machu Picchu, Peru",
        description = "Una antigua ciudad inca situada en lo alto de los Andes.",
        imageUrl = "https://viajes.nationalgeographic.com.es/medio/2018/03/01/machu-picchu_5ff969ae_1280x720.jpg"
    )
)

@Composable
fun PlaceCard(place: Place) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = place.imageUrl),
                contentDescription = place.name,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = place.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = place.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun PlaceList(places: List<Place>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(places) { place ->
            PlaceCard(place = place)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NatureApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("NatureApp") }
            )
        }
    ) { paddingValues ->
        PlaceList(places = places, Modifier.padding(paddingValues))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NatureApp()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NatureApp()
        }
    }
}
