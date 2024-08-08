package com.example.coderabbit_test.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> callApi(
    callApi: suspend () -> T
): Flow<ApiResult<T>> = flow {
    runCatching {
        emit(ApiResult.Loading)
        callApi()
    }.onSuccess {
        emit(ApiResult.Success(it))
    }.onFailure {
        emit(ApiResult.Error(it))
    }
}