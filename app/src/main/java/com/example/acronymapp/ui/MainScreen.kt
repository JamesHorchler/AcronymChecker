package com.example.acronymapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.acronymapp.MainViewModel
import com.example.acronymapp.database.AcronymItemModel

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val acronym = viewModel.acronym.collectAsState()

    Column(

    ) {
        var text by remember { mutableStateOf("HMM") }
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            }
        )

        Button(onClick = {viewModel.getAcronym(text.trim())}) {
            Text(text = "Search Acronym")
        }
        Card(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Text(text = acronym.value.data?.toString() ?: "NULL")
        }
    }

}