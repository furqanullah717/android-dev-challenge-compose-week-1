package com.example.androiddevchallenge.screens

import Animals
import DataResponse
import android.content.Context
import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import com.example.androiddevchallenge.DetailsActivity
import com.example.androiddevchallenge.composble.ActionBar
import com.example.androiddevchallenge.composble.ListImage
import com.example.androiddevchallenge.composble.ListText
import com.example.androiddevchallenge.ui.theme.redLight

@ExperimentalAnimationApi
@Composable
fun HomeScreen(data: DataResponse, context: Context) {
    Scaffold(
        topBar = {
            ActionBar("Pet Adoption", Color.White, Color.Black)
        }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp),
            elevation = 2.dp,
            shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        ) {
            Column {
                Text(
                    text = "Select a pet",
                    style = TextStyle(fontSize = 25.sp),
                    modifier = Modifier.padding(16.dp)
                )
                MyComposeList(
                    modifier = Modifier.padding(12.dp),
                    data.animals, context
                )
            }
        }
    }
}


@ExperimentalAnimationApi
@Composable
fun MyComposeList(
    modifier: Modifier = Modifier,
    items: List<Animals>,
    context: Context
) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            MySimpleListItem(item, context)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun MySimpleListItem(itemViewState: Animals, context: Context) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), elevation = 8.dp,
        shape = RoundedCornerShape(corner = CornerSize(20.dp))
    ) {
        DetailsItem(itemViewState = itemViewState, context)
    }
}

@ExperimentalAnimationApi
@Composable
fun DetailsItem(itemViewState: Animals, context: Context) {
    val imageUrl = itemViewState.photos[0].full
    Column {
        var visible by remember { mutableStateOf(false) }
        var favorite by remember { mutableStateOf(false) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                elevation = 0.dp,
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            val intent = Intent(context, DetailsActivity::class.java)
                            intent.putExtra("data", itemViewState)
                            context.startActivity(intent)
                        }
                ) {
                    ListImage(imageUrl)
                    Column(modifier = Modifier.padding(10.dp)) {

                        Text(text = itemViewState.name, style = TextStyle(fontSize = 18.sp))
                        ListText("Breed : " + itemViewState.breeds.primary)
                        ListText("Age : " + itemViewState.age)
                        ListText("Gender : " + itemViewState.gender)

                    }
                    IconButton(
                        onClick = { favorite = !favorite },
                        Modifier.padding(4.dp)
                    ) {
                        val color = if (favorite) Color.Red else Color.Black
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                            tint = color
                        )
                    }
                }
            }
        }
        Column(
            Modifier
                .clickable { visible = !visible }
                .fillMaxWidth()
                .background(color = redLight)

        ) {
            val msg = if (visible) "<< Less" else "More >>"
            AnimatedVisibility(visible = visible) {
                Card(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth(),
                    backgroundColor = redLight
                ) {
                    Text(
                        text = itemViewState.description, modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        style = TextStyle(color = Color.White)
                    )
                }
            }
            Text(
                text = AnnotatedString(msg), modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(), textAlign = TextAlign.End,
                style = TextStyle(color = Color.White)
            )
        }

    }
}
