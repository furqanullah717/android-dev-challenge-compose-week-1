package com.example.androiddevchallenge.composble

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ListImage(imageUrl: String) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = 0.dp,
    ) {
        GlideImage(
            imageModel = imageUrl,
            requestOptions = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop(),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(height = 120.dp)
                .width(width = 120.dp),
            alignment = Alignment.Center
        )
    }
}
@Composable
fun ListText(msg:String){
    Text(
        text = msg,
        style = TextStyle(
            fontSize = 14.sp,
            color = Color.Gray
        )
    )
}