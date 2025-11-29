package pt.iade.ei.gamestore.view.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.controller.GameController
import pt.iade.ei.gamestore.model.Item
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


@Composable
fun ItemCard(item: Item, aoClicar: (Item) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { aoClicar(item) }, // passa o item clicado
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val imageRes = GameController.getImageFromUrl(item.imageUrl)
        Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Imagem do item",
                modifier = Modifier
                    .size(110.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )


        // Nome, descrição condensada e preço
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                text = item.description.ifBlank { "Descrição não disponível." },
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis //define o que acontece quando o texto é maior do que o espaço disponível. -> corta o texto e coloca “…” no fim (reticências).
            )

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = String.format(" $%.2f ", item.price),//converte o preço num formato com duas casas decimais usando string.format
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 15.sp
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemCard() {
    val sampleItem = Item(
        1,
        "Cottage Living",
        "https://fake.api/images/cottageliving",
        "The Sims 4 Cottage Living oferece uma experiência campestre com animais, cultivo de alimentos frescos e uma comunidade unida. Interage com vacas e galinhas, cultiva vegetais e explora a aldeia para novas aventuras rurais.",
        39.99
    )
    ItemCard(item = sampleItem, aoClicar = { })
}
