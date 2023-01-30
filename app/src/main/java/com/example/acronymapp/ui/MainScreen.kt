package com.example.acronymapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.acronymapp.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val acronym = viewModel.acronym.collectAsState()

    Column(

    ) {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            }
        )
        Card() {
            Text(text = acronym.value.data?.sf ?: "NULL")
        }
    }

}

@Composable
fun TextFieldAc() {

}