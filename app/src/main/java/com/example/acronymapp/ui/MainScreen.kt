package com.example.acronymapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.acronymapp.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val acronym = viewModel.acronym.collectAsState()

    Column(

    ) {
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            }
        )

        Button(onClick = { viewModel.getAcronym(text.trim()) }) {
            Text(text = "Search Acronym")
        }
        if (acronym.value.data != null)
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(acronym.value.data!![0].lfs) { item ->
                    Text(text = " Long form: " + item.lf.capitalize() +
                    "\n Frequency: " + item.freq +
                            "\n Since: " + item.since +"\n"
                    )

                }
            }
    }

}