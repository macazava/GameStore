package pt.iade.ei.gamestore.view.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.R
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Nome acima da imagem
            Text(
                text = item.name.ifBlank { "Item sem nome" },
                style = MaterialTheme.typography.titleLarge
            )

            // Imagem à esquerda e descrição à direita
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = item.imageResId),
                    contentDescription = "Imagem do item",
                    modifier = Modifier
                        .size(100.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = item.description.ifBlank { "Descrição não disponível." },
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
            }

            // Preço e botão na parte inferior
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$ ${String.format("%.2f", item.price)}",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.width(15.dp)) // espaço entre preço e botão

                Button(
                    onClick = {
                        Toast.makeText(
                            contexto,
                            "Acabou de comprar o item ${item.name} por $${String.format("%.2f", item.price)}",
                            Toast.LENGTH_LONG
                        ).show()
                        aoFechar()
                    }
                ) {
                    Text("Buy with 1-click")
                }
            }


            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Preview
@Composable
fun PreviewPurchaseBottomSheet(){
    PurchaseBottomSheet(
        Item(1,"Cottage Living",R.drawable.expansionpackcottageliving_itemimage,"The Sims™ 4 Cottage Living oferece uma experiência campestre com animais, cultivo de alimentos frescos e uma comunidade unida. Interage com vacas e galinhas, cultiva vegetais e explora a aldeia para novas aventuras rurais.", 39.99),
        aoFechar = {}
    )
}