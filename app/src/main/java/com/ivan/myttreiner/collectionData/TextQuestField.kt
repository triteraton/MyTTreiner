package com.ivan.trener.test

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
import com.ivan.myttrener_v2.collectionData.QuestField

class TextQuestField(questText: String) : QuestField(questText) {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Draw (){
        val message = remember{mutableStateOf("")}
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp)) {
            Text(modifier = Modifier.padding(start = 10.dp),text = getQuestText())
            Row(){
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = message.value,
                    textStyle = TextStyle(fontSize=25.sp),
                    onValueChange = {newText -> message.value = newText
                    setResult(message.value)}
                )
            }
        }
    }
}


