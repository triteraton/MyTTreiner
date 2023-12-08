package com.ivan.myttrener_v2.userData

//import com.google.firebase.database.IgnoreExtraProperties
//
//@IgnoreExtraProperties
data class User(
    var id: Int,
    var userData: MutableMap<String, Int> = mutableMapOf(
        "weight" to 0,
        "height" to 0,
        "waist" to 0,
        "hip" to 0,
        "age" to 0,
        "sex" to 0,
        "expect" to 0,
        "injur" to 0,
    )
) {
    // Дополнительные свойства и методы класса User можно добавить здесь
}