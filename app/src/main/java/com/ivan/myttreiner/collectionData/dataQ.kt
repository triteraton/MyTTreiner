package com.ivan.myttreiner.collectionData

data class dataQ (

    var questions: List<QuestField> =  listOf(
        TextQuestField(questText = "Укажите ваш вес", "68"),
        TextQuestField(questText = "Укажите ваш рост", "176"),
        TextQuestField(questText = "Укажите обхват вашей талии", "70"),
        TextQuestField(questText = "Укажите обхват ваших бёдер", "97"),
        TextQuestField(questText = "Укажите ваш возраст", "21"),
        Question("Укажите ваш пол", listOf("Мужской", "Женский"))
    ),
    var dataResult: List<Int> = listOfNotNull(-1,-1,-1,-1,-1,-1,-1,-1)
){

    fun getQuests(): List<QuestField> {
        return questions
    }

    fun getDataRes(): List<Int> {
        return dataResult
    }

}