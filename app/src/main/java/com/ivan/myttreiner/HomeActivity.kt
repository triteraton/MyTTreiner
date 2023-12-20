package com.ivan.myttreiner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ivan.myttreiner.ui.theme.MyTTreinerTheme


class HomeActivity : ComponentActivity() {

    private val dataStoreManager: DataStoreManager by lazy {
        DataStoreManager(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTTreinerTheme {
                Drawer()
            }
        }
    }
}