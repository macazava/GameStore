package pt.iade.ei.gamestore.view.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.gamestore.controller.GameController
import pt.iade.ei.gamestore.model.Game

@Composable
fun GameDetailCard(game: Game) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = game.imageResId),
            contentDescription = "Imagem cortada à direita",
            modifier = Modifier
                .size(160.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop,
            alignment = Alignment.CenterEnd // foca na parte direita da imagem
        )



        // Texto à direita da imagem
        Text(
            text = game.description.ifBlank {
                "."
            },
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 14.sp,
                lineHeight = 17.sp
            ),
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameDetailCard() {
    val sampleGame = GameController.getSampleGames().first()
    GameDetailCard(game = sampleGame)
}

