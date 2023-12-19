package com.ivan.myttreiner.collectionData

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TextQuestField(questText: String, val placeHolder: String) : QuestField(questText) {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun draw(): String {
        val message = remember { mutableStateOf("") }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp)
        ) {
            Text(modifier = Modifier.padding(start = 10.dp), text = getQuestText())
            Row() {
                TextField(
                    placeholder = { Text(text = placeHolder) },
                    modifier = Modifier.fillMaxWidth(),
                    value = message.value,
                    textStyle = TextStyle(fontSize = 25.sp),
                    onValueChange = { newText ->
                        message.value = newText
                        setResult(message.value)
                    }
                )
            }
        }
        return getResult()
    }
}


