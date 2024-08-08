package com.example.coderabbit_test.ui.add.compose

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coderabbit_test.ui.add.AddTodoViewModel
import timber.log.Timber

@Composable
fun AddTodoPage() {
    val viewModel = viewModel<AddTodoViewModel>()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current


    AddTodoTemplate(
        body = state.content,
        onSetBody = { viewModel.setBody(it) },
        onSave = {
            viewModel.save()
            (context as Activity).finish()
            Toast.makeText(context, "Todoを保存しました", Toast.LENGTH_SHORT).show()
        }
    )

}


