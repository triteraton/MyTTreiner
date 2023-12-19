package com.ivan.myttreiner.collectionData


import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ivan.myttreiner.ui.theme.MyTTreinerTheme

@Composable
fun FullScreenOfQuest(){
    MyTTreinerTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
            ) {
            DrawQuestions()
        }
    }
}

@Composable
fun DrawQuestions(){
    val quests = dataQ().getQuests()

    Column (modifier = Modifier
        .background(Color.Gray)
        .fillMaxSize()
        .verticalScroll(
            ScrollState(0)
        )
        .padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){
        quests.forEach { quest ->
            quest.Draw()

        }
        Button(
            modifier = Modifier
                .width(350.dp)
                .height(60.dp)
                .padding(top = 5.dp, bottom = 5.dp),
            onClick = { println("") }
        ) {
            Text(
                text = "Сохранить результаты",
                fontWeight = FontWeight.Bold
            )
        }
    }
}


