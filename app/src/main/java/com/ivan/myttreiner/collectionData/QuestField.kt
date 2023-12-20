package com.ivan.myttreiner.collectionData

import androidx.compose.runtime.Composable


open class QuestField(
    private var questText: String,
    private var result: String = "",
) {
    @Composable
    open fun draw (): String{
        return ""
    }
    fun getQuestText(): String {
        return questText
    }

    fun getResult(): String {
        return result
    }

    fun setResult(value: String) {
        result = value
    }


}