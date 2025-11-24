package pt.iade.ei.gamestore.view.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.controller.GameController
import pt.iade.ei.gamestore.model.Item

@Composable
fun ItemCard(item: Item, aoClicar: (Item) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { aoClicar(item) }, // passa o item clicado
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = item.name.ifBlank { "Imagem do item" },
            modifier = Modifier.size(64.dp)
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = item.name, style = MaterialTheme.typography.titleMedium)
            Text(text = item.description.ifBlank { "Descrição não disponível." }, style = MaterialTheme.typography.bodySmall)
        }
        Text(text = String.format("%.2f €", item.price), style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemCard() {
    val sampleItem = GameController.getSampleGames().first().items.first() // Cottage Living
    ItemCard(item = sampleItem, aoClicar = { println("Clicado: ${it.name}") })
}