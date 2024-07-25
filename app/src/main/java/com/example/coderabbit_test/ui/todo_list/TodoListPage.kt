package com.example.coderabbit_test.ui.todo_list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListPage(viewModel: TodoListViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    var docCount by remember { mutableIntStateOf(0) }

    val listState = rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = { Text("<TODO LIST>") },
                navigationIcon = {
                    IconButton(modifier = Modifier,
                        onClick = { }) {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.ArrowBack),
                            contentDescription = null,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                },
                actions = {
                    IconButton(modifier = Modifier,
                        onClick = {
                            viewModel.addCount()
                        }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                        )
                    }
                    IconButton(modifier = Modifier,
                        onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            state = listState
        ) {
            items(uiState) { i ->
                if (i == 0) {
                    Text(
                        modifier = Modifier
                            .height(32.dp)
                            .fillMaxWidth(),
                        text = docCount.toString(),
                        textAlign = TextAlign.Center
                    )
                }
                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                )
                TodoItem(
                    title = "TITLE $i",
                    headline = "########### HEADLINE DESCRIPTION $i ###########",
                    onClick = {
                        //TODO 編集画面へ
                    }
                )
            }
        }

        LaunchedEffect(uiState) {//modelの値が変更されたら表示のアプデ
            docCount = uiState.size
            Log.d("######DEBUG", "UISTATE : ${uiState}")
        }
    }
}

@Composable
fun TodoItem(title: String, headline: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(text = headline, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
        IconButton(onClick = { onClick() }) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = null)
        }
    }
}