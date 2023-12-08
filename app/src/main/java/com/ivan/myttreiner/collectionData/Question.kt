package com.ivan.myttrener_v2.collectionData

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
import com.ivan.myttrener_v2.userData.User

class Question(
    questText: String,
    private var answerOptions: List<String>,
) : QuestField(questText) {

    fun getAnswerOptions(): List<String> {
        return answerOptions
    }

    fun setAnswerOptions(options: List<String>) {
        answerOptions = options
    }

    @Composable
    override fun Draw (){
        val selectedOption = remember { mutableStateOf(answerOptions[0]) }
        var i = 0
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
                            /*User.userData[compare(i)] = item*/})
                        Text(text = item)
                    }
                    i++
                }
            }
        }
    }
/*
    fun compare(index: Int): String {
        if (index == 0){
            return "weight"
        }else if(index == 1){
            return "height"
        }else if(index == 2){
            return "waist"
        }else if(index == 3){
            return "hip"
        }else if(index == 4){
            return "age"
        }else if(index == 5){
            return "sex"
        }else if(index == 6){
            return "expect"
        }else if(index == 7){
            return "injur"
        }else return "Wrong index"

    }*/
}

