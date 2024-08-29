package com.example.coderabbit_test.ui.add

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.coderabbit_test.repository.TodoDatabase
import com.example.coderabbit_test.repository.TodoRepository
import com.example.coderabbit_test.ui.add.compose.AddTodoPage
import com.example.coderabbit_test.ui.theme.CodeRabbit_TestTheme
import dagger.hilt.android.AndroidEntryPoint

class AddTodoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val todoDao = TodoDatabase.getDatabase(this).todoDao()
        setContent {
            CodeRabbit_TestTheme {
                AddTodoPage(TodoRepository(todoDao))
            }
        }
    }
}