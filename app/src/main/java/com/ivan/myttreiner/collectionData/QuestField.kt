package com.ivan.myttrener_v2.collectionData

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

open class QuestField(
    private var questText: String,
    private var result: String = ""
) {
    fun getQuestText(): String {
        return questText
    }

    fun setQuestText(text: String) {
        questText = text
    }

    fun getResult(): String {
        return result
    }

    fun setResult(value: String) {
        result = value
    }

    @Composable
    open fun Draw(){

    }
}