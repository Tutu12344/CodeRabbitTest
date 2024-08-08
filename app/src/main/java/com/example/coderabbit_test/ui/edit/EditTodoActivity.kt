package com.example.coderabbit_test.ui.edit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.coderabbit_test.ui.edit.compose.EditTodoPage
import com.example.coderabbit_test.ui.theme.CodeRabbit_TestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditTodoActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getIntExtra("id", 0)
        setContent {
            CodeRabbit_TestTheme {
                EditTodoPage(id = id)
            }
        }
    }
}