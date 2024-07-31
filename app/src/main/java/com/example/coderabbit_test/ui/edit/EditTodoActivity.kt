package com.example.coderabbit_test.ui.edit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.coderabbit_test.repository.TodoDatabase
import com.example.coderabbit_test.repository.TodoRepository
import com.example.coderabbit_test.ui.edit.compose.EditTodoPage
import com.example.coderabbit_test.ui.theme.CodeRabbit_TestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditTodoActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val todoDao = TodoDatabase.getDatabase(this).todoDao()
        val id = intent.getIntExtra("id", 0)

        setContent {
            CodeRabbit_TestTheme {
                EditTodoPage(todoRepository = TodoRepository(todoDao), id = id)
            }
        }
    }
}