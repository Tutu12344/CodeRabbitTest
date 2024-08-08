package com.example.coderabbit_test.ui.todo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coderabbit_test.model.TodoEntity
import com.example.coderabbit_test.repository.ApiResult
import com.example.coderabbit_test.repository.TodoRepository
import com.example.coderabbit_test.repository.callApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(private val todoRepository: TodoRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow<List<TodoEntity>>(emptyList())
    val uiState: StateFlow<List<TodoEntity>> = _uiState.asStateFlow()

    fun getTodos() = viewModelScope.launch {
        callApi {
            todoRepository.getTodos()
        }.collect {
            when (it) {
                is ApiResult.Success -> {
                    _uiState.value = it.data
                }

                else -> {}
            }
        }
    }

    fun delete(todo: TodoEntity) = viewModelScope.launch {
        callApi {
            todoRepository.deleteTodo(todo)
        }.collect {
            getTodos()
        }
    }
}