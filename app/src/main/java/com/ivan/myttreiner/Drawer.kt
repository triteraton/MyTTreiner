package com.ivan.myttreiner

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Drawer () {
    val items = listOf(
        DrawerItems(
            Icons.Default.AccountBox,
            "Мой план"
        ),
        DrawerItems(
            Icons.Default.Edit,
            "Сменить план"
        ),
        DrawerItems(
            Icons.Default.ExitToApp,
            "Выйти"
        )
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
                                drawerState.close()
                            }
                        }
                    )
                }
            }
        }, content = {
            Box(modifier = Modifier.fillMaxSize()/*,
                contentAlignment = Alignment.Center*/
            ){
                Button(onClick ={
                    scope.launch {
                        drawerState.open()
                    }
                }){
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "меню")
                }
            }
        })
}

data class DrawerItems(
    val imageVector: ImageVector,
    val title: String
)