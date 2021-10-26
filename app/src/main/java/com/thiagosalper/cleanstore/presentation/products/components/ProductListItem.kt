package com.thiagosalper.cleanstore.presentation.products.components

import android.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.thiagosalper.cleanstore.domain.model.Product

@Composable
fun ProductListItem(
    product: Product,
    onItemClick: (Product) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(Product) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${product.name}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "${product.price}",
            color = Color.RED,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}