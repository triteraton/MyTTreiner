package com.ivan.myttreiner

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ivan.myttreiner.collectionData.FullScreenOfQuest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Drawer () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen"){
        composable("MainScreen"){ MainScreen()}
        composable("FullScreenOfQuest"){FullScreenOfQuest()}
    }
    val items = listOf(
        DrawerItems(
            Icons.Default.AccountBox,
            "Мой план"
        ) {
            navController.navigate("MainScreen")
        },
        DrawerItems(
            Icons.Default.Edit,
            "Сменить план",
        ){
            navController.navigate("FullScreenOfQuest")
        }
    )
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedItem = remember {
        mutableStateOf(items[0])
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet{
                items.forEach{ item ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(5.dp),
                        label = {
                                Text(text = item.title)
                        },
                        selected = selectedItem.value == item,
                        icon = {
                               Icon(
                                   imageVector = item.imageVector,
                                   contentDescription = item.title)
                        },
                        onClick = {
                            scope.launch {
                                selectedItem.value = item
                                item.action()
                                drawerState.close()

                            }
                        }
                    )
                }
            }
        }, content = {
            Button(onClick ={
                scope.launch {
                    drawerState.open()
                }
            }){
                Icon(imageVector = Icons.Default.Menu, contentDescription = "меню")
            }
        })
}

data class DrawerItems(
    val imageVector: ImageVector,
    val title: String,
    val action: () -> Unit
)