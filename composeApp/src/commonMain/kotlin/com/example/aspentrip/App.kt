package com.example.aspentrip

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import aspentrip.composeapp.generated.resources.Hiatus
import aspentrip.composeapp.generated.resources.Montserrat
import aspentrip.composeapp.generated.resources.Res
import aspentrip.composeapp.generated.resources.location_1
import aspentrip.composeapp.generated.resources.arrow_down
import aspentrip.composeapp.generated.resources.main_menu
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.AsyncImage
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable

fun App() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "main") {
        composable("main") {
            StartScreen(navController)
        }

        composable("locations") {
            LocationsList(navController)
        }
    }
}

@Composable
fun StartScreen(navController: NavController) {
    val hiatus = FontFamily(Font(Res.font.Hiatus))
    val montserrat = FontFamily(Font(Res.font.Montserrat))

    MaterialTheme {
        Image(painterResource(Res.drawable.main_menu),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Aspen",
                color = Color.White,
                fontSize = 100.sp,
                fontFamily = hiatus,
                letterSpacing = 8.sp,
                modifier = Modifier.padding(20.dp, 80.dp))
            Spacer(Modifier.weight(1.0f))
            Text("Plan your",
                color = Color.White,
                fontSize = 30.sp,
                fontFamily = montserrat,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight(550),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp))
            Text("Luxurious\n\nVacation",
                color = Color.White,
                fontSize = 45.sp,
                fontFamily = montserrat,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight(900),
                modifier = Modifier.fillMaxWidth().padding(30.dp, 10.dp))
            Button(onClick = {navController.navigate("locations")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(23, 111, 242)
                ),
                modifier = Modifier.fillMaxWidth().height(100.dp).padding(20.dp)
            ) {
                Text("Explore",
                    fontSize = 20.sp,
                    fontFamily = montserrat,
                    fontWeight = FontWeight(750))
            }
            Spacer(Modifier.height(30.dp))
        }
    }
}

suspend fun fetchLocations(client: HttpClient, url: String): HttpResponse{
    return client.get(url) {
        header("location", "aspen")
    }
    //print(response)
}

@Composable
@Preview()
fun LocationsList(navController: NavController?) {
    val montserrat = FontFamily(Font(Res.font.Montserrat))
    val client = HttpClient()

    runBlocking {
        launch  {
            val landmarks = fetchLocations(client, "http://192.168.0.189:3001/landmarks")
            print(landmarks)
        }
    }

    var tabs = arrayOf("Locations", "Hotels", "Food", "Adventure", "Nightlife", "Beach")
    var selected by remember { mutableStateOf(0) }

    MaterialTheme {
        Column(modifier = Modifier
            .background(color = Color.White).fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeContent)) {
            Row(modifier = Modifier.fillMaxWidth().height(90.dp)) {
                Column(modifier = Modifier
                    .width(200.dp)
                    .padding(horizontal = 0.dp, vertical = 5.dp)) {
                    Text("Explore",
                        fontSize = 25.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(500)
                    )
                    Text("Aspen",
                        fontSize = 40.sp,
                        fontFamily = montserrat,
                        fontWeight = FontWeight(800)
                    )
                }
                Spacer(Modifier.weight(1.0f))
                //AsyncImage(model = Res.drawable.location_1,
                //    contentDescription = null,
                //    modifier = Modifier.size(30.dp)
                //)
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxHeight()) {
                    Image(painterResource(Res.drawable.location_1),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp))
                    Text("Aspen, USA",
                        fontSize = 15.sp,
                        fontFamily = montserrat,
                    )
                    Image(painterResource(Res.drawable.arrow_down),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp))
                }
            }
            Row(modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 0.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically) {
                for ((i, tab) in tabs.withIndex()) {
                    val thisSelected = i == selected

                    Button(onClick = {selected = i},
                        colors = ButtonDefaults.buttonColors(
                            containerColor =
                                if (thisSelected)
                                    Color(23, 111, 242).copy(
                                        alpha = 0.2f
                                    )
                                else Color.LightGray.copy(
                                    alpha = 0.2f
                                )
                        ),
                        modifier = Modifier
                            .scale(if (thisSelected) 1.1f else 1.0f )
                            .padding(horizontal = if (thisSelected) 8.dp else 2.dp
                                , vertical = 0.dp)
                    ) {
                        Text(tab,
                            color =
                                if (thisSelected) Color.Blue else Color.Black,
                            fontFamily = montserrat,
                            fontWeight =
                                if (thisSelected) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }
            Text("Overview",
                fontSize = 35.sp,
                fontFamily = montserrat,
                fontWeight = FontWeight(800),
                modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)
            )

        }
    }
}