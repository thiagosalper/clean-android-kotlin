package com.thiagosalper.cleanstore.presentation

sealed class Screen(val route: String) {
    object ProductListScreen: Screen("product_list_screen")
}
