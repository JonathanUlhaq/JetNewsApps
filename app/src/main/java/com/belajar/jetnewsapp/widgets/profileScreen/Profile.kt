package com.belajar.jetnewsapp.widgets.profileScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp


@Composable
fun Profile(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .size(100.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "photo",
                    tint = Color.White,
                    modifier = Modifier
                        .size(80.dp)
                )
            }
        }

        Divider(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp))

        Text(text = buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Start)) {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Name: ")

                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("Jovian")
                    }
                }
            }
        })
        Divider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
        Text(text = buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Start)) {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Age: ")

                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("21")
                    }
                }
            }
        })
        Divider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
        Text(text = buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Start)) {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Country: ")

                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("Indonesia")
                    }
                }
            }
        })
    }
}