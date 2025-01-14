package com.ricardo.workshop.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun ToastListScreen(
    modifier: Modifier = Modifier,
    viewModel: ToastListViewModel
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    // async code
    LaunchedEffect(Unit) {
        println("fetching data")
        viewModel.getToasts()
    }

    ToastListScreenContent(
        modifier = modifier,
        uiState = uiState.value,
        onSearchItem = { viewModel.getToasts(it) }
    )
}
