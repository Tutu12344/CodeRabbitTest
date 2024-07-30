package com.example.coderabbit_test.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coderabbit_test.model.TodoEntity
import com.example.coderabbit_test.repository.ApiResult
import com.example.coderabbit_test.repository.TodoRepository
import com.example.coderabbit_test.repository.callApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class EditTodoViewModel @Inject constructor(private val todoRepository: TodoRepository) :
    ViewModel() {

    private val _state = MutableStateFlow(TodoEntity(id = 0, content = ""))
    val state = _state.asStateFlow()

    fun update() = viewModelScope.launch {
        callApi {
            todoRepository.updateTodo(_state.value)
        }.collect{}
    }

    fun getTodo(id:Int) = viewModelScope.launch {
        callApi {
            todoRepository.getTodo(id)
        }.collect {
            when (it) {
                is ApiResult.Success -> {
                    _state.value = TodoEntity(
                        id = it.data.id,
                        content = it.data.content
                    )
                }
                else -> {}
            }
        }
    }


    fun setBody(body: String) {
        _state.value = _state.value.copy(content = body)
    }
}
