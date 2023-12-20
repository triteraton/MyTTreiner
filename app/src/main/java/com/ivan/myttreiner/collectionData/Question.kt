package com.ivan.myttreiner.collectionData

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Question(
    questText: String,
    private var answerOptions: List<String>,
) : QuestField(questText) {

    @Composable
    override fun draw (): String {
        val selectedOption = remember { mutableStateOf(answerOptions[0]) }
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp)) {
            Text(modifier = Modifier.padding(start = 10.dp),text = getQuestText())
            Column(Modifier.selectableGroup()){
                answerOptions.forEach { item ->
                    val selected = selectedOption.value == item
                    Row(){
                        RadioButton(selected = selected, onClick = {
                            selectedOption.value = item
                            setResult(item)
                        })
                        Text(text = item)
                    }
                }
            }
        }
        return getResult()
    }
}

