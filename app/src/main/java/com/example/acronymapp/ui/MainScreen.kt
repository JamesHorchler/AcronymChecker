package com.example.acronymapp.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.acronymapp.MainViewModel
import com.example.acronymapp.database.AcronymItemModel
import com.example.acronymapp.database.LfModel
import com.example.acronymapp.util.Resource

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val acronym = viewModel.acronym.collectAsState()

    Column{
        var text by remember { mutableStateOf("") }
//        val focusManager = LocalFocusManager.current

        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
//            keyboardOptions = KeyboardOptions(
//                imeAction = ImeAction.Done,
//                keyboardType = KeyboardType.Password
//            ),
//            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
//            focusManager = focusManager,
        )

        Button(onClick = { viewModel.getAcronym(text.trim()) }) {
            Text(text = "Search Acronym")
        }

        when (acronym.value) {
            is Resource.Error -> {
                Toast.makeText(LocalContext.current, acronym.value.message, Toast.LENGTH_SHORT)
                    .show()
            }
            is Resource.Success<*> -> {
                val result = acronym.value as Resource<List<AcronymItemModel>>
                if (!acronym.value.data.isNullOrEmpty())
                    LazyColumn(modifier = Modifier.padding(16.dp)) {
                        items(
                            result.data?.get(0)?.lfs ?: listOf(LfModel(lf = "No Item Found!"))
                        ) { item ->
                            setTextView(item)
                        }
                    }
                else setTextView(item = LfModel(lf = "No Item Found!"))
            }
            else -> {
                Toast.makeText(LocalContext.current, "Loading. . .", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
private fun setTextView(item: LfModel){
    Text(
        text = " Long form: " + item.lf.capitalize() +
                "\n Frequency: " + item.freq +
                "\n Since: " + item.since + "\n"
    )
}