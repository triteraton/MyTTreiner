package com.ivan.myttrener_v2.collectionData

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ivan.trener.test.TextQuestField

class CollectionData {
    var questions: List<QuestField> =  listOf(
        TextQuestField(questText = "Укажите ваш вес"),
        TextQuestField(questText = "Укажите ваш рост"),
        TextQuestField(questText = "Укажите обхват вашей талии"),
        TextQuestField(questText = "Укажите обхват ваших бёдер"),
        TextQuestField(questText = "Укажите ваш возраст"),
        Question("Укажите ваш пол", listOf("Мужской", "Женский")),
        Question("Ваши ожидания от тренировок", listOf("Снизить вес", "Увеличить мышечную массу", "оставаться в тонусе")),
        Question("Укажите имеющиеся у вас травмы", listOf("Травма ног", "Травма рук", "Травма шеи", "Травма спины", "Полностью здоров"))
    )

    fun getQuests(): List<QuestField> {
        return questions
    }

}

@Composable
fun FullScreenOfQuest(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray),

    ){
        DrawQuestions()
    }
}


@Composable
fun DrawQuestions(){
    val quests = CollectionData().getQuests()
    Column (modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(
            ScrollState(0)
        )
        .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom){
        quests.forEach { quest ->
            quest.Draw()
        }
        Button(
            modifier = Modifier
                .width(350.dp)
                .height(60.dp)
                .padding(top = 5.dp, bottom = 5.dp),
            onClick = {/* need to add code*/}
        ) {
            Text(
                text = "Сохранить результаты",
                fontWeight = FontWeight.Bold
            )
        }
    }
}