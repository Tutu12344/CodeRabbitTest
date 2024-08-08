package com.example.coderabbit_test.ui.edit.compose

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coderabbit_test.ui.add.compose.AddTodoTemplate
import com.example.coderabbit_test.ui.edit.EditTodoViewModel

@Composable
fun EditTodoPage(id: Int) {
    val viewModel = viewModel<EditTodoViewModel>()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.getTodo(id)
    }

    EditTodoTemplate(
        body = state.content,
        onSetBody = { viewModel.setBody(it) },
        onUpdate = {
            viewModel.update()
            (context as Activity).finish()
            Toast.makeText(context, "Todoを更新しました", Toast.LENGTH_SHORT).show()
        },
    )

}


