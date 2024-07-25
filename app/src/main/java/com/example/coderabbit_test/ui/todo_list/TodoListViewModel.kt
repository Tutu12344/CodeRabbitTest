package com.example.coderabbit_test.ui.todo_list

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow((0..9).toMutableList())
    val uiState: StateFlow<MutableList<Int>> = _uiState.asStateFlow()

    fun addCount() {
        _uiState.value = (_uiState.value + (_uiState.value.size)).toMutableList()
    }
}