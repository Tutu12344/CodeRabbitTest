package com.example.coderabbit_test.repository

import com.example.coderabbit_test.model.TodoEntity

interface TodoRepositoryInterface {

    suspend fun insertTodo(todo: TodoEntity)

    suspend fun deleteTodo(todo: TodoEntity)

    suspend fun updateTodo(todo: TodoEntity)

    suspend fun getTodo(id:Int): TodoEntity

    suspend fun getTodos(): List<TodoEntity>

}

class TodoRepository(private val todoDao: TodoDao) : TodoRepositoryInterface {

    override suspend fun insertTodo(todo: TodoEntity) {
        todoDao.insert(todo)
    }

    override suspend fun deleteTodo(todo: TodoEntity) {
        todoDao.delete(todo)
    }

    override suspend fun updateTodo(todo: TodoEntity) {
        todoDao.update(todo)
    }

    override suspend fun getTodo(id:Int): TodoEntity {
        return todoDao.getTodo(id)
    }

    override suspend fun getTodos(): List<TodoEntity> {
        return todoDao.getAll()
    }
}