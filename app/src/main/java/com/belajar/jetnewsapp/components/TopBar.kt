package com.belajar.jetnewsapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TopBar(
    title: String,
    isHomeScreen: Boolean,
    search: MutableState<String> = mutableStateOf(""),
    color:Color,
    navController: NavController,
    onKeyboardAction:() -> Unit
) {

    val close = remember {
        mutableStateOf(false)
    }

    close.value = search.value.isNotEmpty()

    TopAppBar(
        backgroundColor = color,
        elevation = 0.dp,
        modifier = Modifier
            .padding(top = 16.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
    ) {
        if (isHomeScreen) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = search.value,
                    onValueChange = { search.value = it },
                    trailingIcon = {
                        when (close.value) {
                            true -> {
                                IconButton(onClick = { search.value = "" }) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "close search"
                                    )
                                }
                            }

                            else -> {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "search"
                                )
                            }
                        }
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                        cursorColor = Color.LightGray
                    ),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions {
                        onKeyboardAction.invoke()
                    },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .height(50.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                IconButton(onClick = { /*TODO*/ }) {
                    Surface(
                        shape = CircleShape,
                        modifier = Modifier
                            .size(32.dp),
                        color = MaterialTheme.colors.primary
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "notif",
                            tint = Color.White,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
            }
        } else {
            IconButton(onClick = { navController.popBackStack() }) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = Color.LightGray
                ) {
                        Icon(imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(12.dp))
                }
            }
        }
    }
}