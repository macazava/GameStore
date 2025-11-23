package pt.iade.ei.gamestore.view.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.controller.GameController
import pt.iade.ei.gamestore.model.Game

@Composable
fun GameDetailCard(game: Game) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(id = game.imageResId),
            contentDescription = game.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(
            text = game.description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameDetailCard() {
    val sampleGame = GameController.getSampleGames().first() // The Sims 4
    GameDetailCard(game = sampleGame)
}


