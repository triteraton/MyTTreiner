package com.ivan.myttreiner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen (){
    Box(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize()
    ){
        Text(text = "main activity")
    }
}