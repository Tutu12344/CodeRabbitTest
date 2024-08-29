package com.example.coderabbit_test.repository


sealed interface ApiResult<out R> {
    data class Success<out T>(val data: T) : ApiResult<T>
    object Loading : ApiResult<Nothing>
    data class Error(val error: Throwable) : ApiResult<Nothing>
}