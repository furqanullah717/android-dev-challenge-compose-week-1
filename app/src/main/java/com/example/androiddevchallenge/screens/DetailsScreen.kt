package com.example.androiddevchallenge.screens

import Animals
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.composble.ListText
import com.example.androiddevchallenge.ui.theme.redLight
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalAnimationApi
@Composable
fun DetailScreen(animals: Animals) {

    Scaffold(
        topBar = {
        }) {
        Column(
            Modifier
                .background(color = redLight)
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            TwoAreas(animals)
        }
    }
}

@Composable
fun DetailsImage(imageUrl: String) {
    GlideImage(
        imageModel = imageUrl,
        requestBuilder = Glide
            .with(LocalView.current)
            .asBitmap()
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
            .thumbnail(0.1f)
            .transition(withCrossFade())
            .override(2000),
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        contentScale = ContentScale.FillBounds
    )
}

@ExperimentalAnimationApi
@Composable
fun TwoAreas(itemViewState: Animals) {
    val imageUrl = itemViewState.photos[0].full
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1.0f, true)
                        .background(color = Color.Gray),
                    verticalArrangement = Arrangement.Center
                ) {
                    DetailsImage(imageUrl = imageUrl)
                }
            }


            LazyColumn(
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                        ) {
                            Spacer(modifier = Modifier.height(40.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Row(modifier = Modifier.weight(1.0f)) {
                                    FeatureItem("Age", itemViewState.age)
                                }
                                Row(modifier = Modifier.weight(1.0f)) {
                                    FeatureItem("Sex", itemViewState.gender)
                                }
                                Row(modifier = Modifier.weight(1.0f)) {
                                    FeatureItem("Size", itemViewState.size)
                                }
                                val color = itemViewState.colors.primary
                                Row(modifier = Modifier.weight(1.0f)) {
                                    FeatureItem("Color", color)
                                }
                            }
                            Row(
                                modifier = Modifier
                                    .background(color = redLight)
                                    .height(1.dp)
                                    .padding(horizontal = 20.dp)
                                    .fillMaxWidth()
                            ) {}

                            Text(
                                text = "Contact ",
                                modifier = Modifier.padding(
                                    horizontal = 20.dp,
                                    vertical = 10.dp
                                ),
                                style = TextStyle(fontSize = 20.sp)
                            )

                            Text(
                                text = "Email : " + itemViewState.contact.email,
                                modifier = Modifier.padding(
                                    horizontal = 20.dp,
                                    vertical = 10.dp
                                )
                            )
                            Text(
                                text = "Phone : " + itemViewState.contact.phone,
                                modifier = Modifier.padding(
                                    horizontal = 20.dp,
                                    vertical = 10.dp
                                )
                            )
                            Column {
                                AnimatedVisibility(visible = true) {
                                    Card(
                                        elevation = 0.dp,
                                        shape = RoundedCornerShape(10.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                    ) {
                                        Text(
                                            text = itemViewState.description,
                                            modifier = Modifier
                                                .padding(horizontal = 20.dp, vertical = 10.dp)
                                                .fillMaxWidth(),
                                            style = TextStyle(color = Color.Black)
                                        )
                                    }
                                }
                            }


                        }
                    }
                }
            }


        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(30.dp),
            elevation = 14.dp
        ) {
            MainCard(itemViewState)
        }
    }
}

@Composable
fun MainCard(itemViewState: Animals) {

    var favorite by remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.height(100.dp)) {
            Text(text = itemViewState.name, style = TextStyle(fontSize = 30.sp))
            ListText("Breed : " + itemViewState.breeds.primary)
            ListText("Age : " + itemViewState.age)
            ListText("Gender : " + itemViewState.gender)
        }
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = { favorite = !favorite },
                    Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .padding(start = 8.dp)
                ) {
                    val color = if (favorite) Color.Red else Color.Black
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Localized description",
                        tint = color
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "$76",
                    style = TextStyle(fontSize = 30.sp, color = redLight),
                    textAlign = TextAlign.Center
                )
            }

        }

    }
}

@Composable
fun FeatureItem(title: String, value: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 0.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = TextStyle(textAlign = TextAlign.Center),
                modifier = Modifier.padding(10.dp)
            )
        }

        Card(shape = RoundedCornerShape(10.dp), modifier = Modifier.fillMaxWidth()) {
            Text(
                text = value,
                style = TextStyle(
                    color = redLight,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(10.dp)
            )
        }

    }
}