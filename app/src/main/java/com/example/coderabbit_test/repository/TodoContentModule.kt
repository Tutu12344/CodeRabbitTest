package com.example.coderabbit_test.repository

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoContentModule {

    @Singleton
    @Provides
    fun provideTodoRepository(@ApplicationContext context: Context): TodoRepository {
        return TodoRepository(TodoDatabase.getDatabase(context).todoDao())
    }
}