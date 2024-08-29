package com.example.coderabbit_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.coderabbit_test.ui.theme.CodeRabbit_TestTheme
import com.example.coderabbit_test.ui.todo_list.TodoListPage
import com.example.coderabbit_test.ui.todo_list.TodoListPageB
import com.example.coderabbit_test.ui.todo_list.TodoListViewModelB

class MainActivity : ComponentActivity() {
    private var viewModelB = ViewModelProvider(this)[TodoListViewModelB::class.java]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeRabbit_TestTheme {
                TodoListPageB(viewModelB)
            }
        }
    }
}
