package com.example.coderabbit_test.ui.edit.compose

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import com.example.coderabbit_test.model.TodoEntity
import com.example.coderabbit_test.repository.TodoRepository
import kotlinx.coroutines.launch
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTodoPage(id: Int, todoRepository: TodoRepository) {
    /*Problem*/
    var text by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        val todo = todoRepository.getTodo(id)
        /*Problem*/
        Timber.d(todo.toString())
        text = TextFieldValue(todo.content)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = { Text("Edit Todo") },
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Todo") }
                )
                Button(onClick = {
                    /*Problem*/
                    scope.launch {
                        todoRepository.updateTodo(TodoEntity(id = id, content = text.text))
                        (context as Activity).finish()
                        Toast.makeText(context, "Todoを更新しました", Toast.LENGTH_SHORT).show()
                    }
                }) {
                    Text("更新")
                }
            }
        }

    }
}


