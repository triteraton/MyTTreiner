package com.ivan.myttreiner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ivan.myttrener_v2.navigation.appScreen

class MainActivity : ComponentActivity() {
    //private lateinit var database:  DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //database = Firebase.database.reference
        
        setContent {
            Drawer()
            /*val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = appScreen.LogIn.name,
            ){
                composable(route = appScreen.LogIn.name){
                    Login()
                }
                composable(route = appScreen.Main.name){
                    val context = LocalContext.current
                }
            }
            MyTTrener_V2Theme{
                /*NavHost(
                    navController = navController,
                    graph = )*/
            }
            //Drawer()
            //FullScreenOfQuest()*/

        }
    }
}


@Composable
fun Login() {
    Box(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier
                    .width(350.dp)
                    .height(60.dp),
                onClick = {}
            ) {
                Text(
                    text = "Sign In with Google",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}



