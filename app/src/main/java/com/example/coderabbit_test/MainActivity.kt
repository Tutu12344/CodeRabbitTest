package com.example.coderabbit_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.coderabbit_test.ui.theme.CodeRabbit_TestTheme
import com.example.coderabbit_test.ui.todo_list.TodoListPage
import com.example.coderabbit_test.ui.todo_list.TodoListViewModel

class MainActivity : ComponentActivity() {
    private val todoListViewModel: TodoListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeRabbit_TestTheme {
                TodoListPage(viewModel = todoListViewModel)
            }
        }
    }
}
