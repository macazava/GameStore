package pt.iade.ei.gamestore.view.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.model.Game
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.geometry.Offset
import pt.iade.ei.gamestore.controller.GameController


@Composable
fun GameCard(game: Game, onClick: (Game) -> Unit) {
    //estrutura do card
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable { onClick(game) }, //passa o game clicado
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        //conteudo do card
        Box(modifier = Modifier.fillMaxSize()) {
            // usa a função do controller para converter URL em drawable
            val imageRes = GameController.getImageFromUrl(game.imageUrl)
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = game.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
            )
            Text(
                text = game.name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    shadow = Shadow(
                        color = Color.Black.copy(alpha = 0.8f),
                        offset = Offset(4f, 4f),
                        blurRadius = 4f
                    )
                ),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewGameCard() {
    val sampleGame = Game(
        1,
        "The Sims 4",
        "https://fake.api/images/thesims4",
        "The Sims 4 é um jogo de simulação de vida gratuito onde os jogadores criam e controlam Sims. É possível personalizar personagens e casas, gerir as suas carreiras e relacionamentos, e explorar mundos virtuais repletos de eventos.",
        emptyList()
        )
    GameCard(game = sampleGame, onClick = { })
}
