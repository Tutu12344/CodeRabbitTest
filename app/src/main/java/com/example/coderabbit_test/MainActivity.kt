package com.example.coderabbit_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.coderabbit_test.ui.theme.CodeRabbit_TestTheme
import com.example.coderabbit_test.ui.todo_list.TodoListPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeRabbit_TestTheme {
                TodoListPage()
            }
        }
    }
}
