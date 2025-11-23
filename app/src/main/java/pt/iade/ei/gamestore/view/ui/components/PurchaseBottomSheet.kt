package pt.iade.ei.gamestore.view.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.model.Item

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PurchaseBottomSheet(
    item: Item,
    aoFechar: () -> Unit
) {
    val contexto = LocalContext.current
    val estadoSheet = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = aoFechar,
        sheetState = estadoSheet
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Imagem do item
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = item.name,
                modifier = Modifier
                    .size(72.dp)
                    .align(Alignment.Start)
            )

            // Nome do item
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium
            )

            // Descrição completa
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium
            )

            // Preço
            Text(
                text = "Preço: ${String.format("%.2f", item.price)} €",
                style = MaterialTheme.typography.titleSmall
            )

            // Botão de compra
            Button(
                onClick = {
                    Toast.makeText(
                        contexto,
                        "Acabou de comprar o item ${item.name} por ${String.format("%.2f", item.price)} €",
                        Toast.LENGTH_SHORT
                    ).show()
                    aoFechar()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Comprar com 1 clique")
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}



//colocar o preview (perguntar ao professor)



