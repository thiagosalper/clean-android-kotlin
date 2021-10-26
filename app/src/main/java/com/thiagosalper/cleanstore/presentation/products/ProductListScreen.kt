package com.thiagosalper.cleanstore.presentation.products

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.thiagosalper.cleanstore.presentation.Screen
import com.thiagosalper.cleanstore.presentation.products.components.ProductListItem

@Composable
fun ProductListScreen(
    navController: NavController,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.products) { product ->
                ProductListItem(
                    product = product,
                    onItemClick = {
                        navController.navigate(Screen.ProductListScreen.route)
                    }
                )
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}