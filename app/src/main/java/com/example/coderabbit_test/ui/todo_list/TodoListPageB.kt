package com.example.coderabbit_test.ui.todo_list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
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
import androidx.compose.runtime.mutableStateOf
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
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListPageB(viewModel: TodoListViewModelB) {
    val uiState by viewModel.uiState.collectAsState()
    var docCount by remember { mutableStateOf(0) }

    var items = (0..9).toMutableList()

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
                    Row {
                        IconButton(modifier = Modifier,
                            onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Share,
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
                }
            )
        }
    ) { padding ->
Box {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(items) { i ->
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
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "TITLE $i",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(text = "########### HEADLINE DESCRIPTION $i ###########", fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                IconButton(onClick = {
                    viewModel.addCount() }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                }
            }
        }
    }
}

        LaunchedEffect(uiState) {
            items.add(items.size)
            docCount = items.size
        }
    }
}


class TodoListViewModelB : ViewModel() {
    private val _uiState = MutableStateFlow((0..9).toMutableList())//ドキュメントの数
    val uiState: StateFlow<MutableList<Int>> = _uiState.asStateFlow()

    fun addCount() {
        val current = _uiState.value
        current.add(_uiState.value.size)
        _uiState.value = (_uiState.value + (_uiState.value.size)).toMutableList()
    }
}