package pt.iade.ei.gamestore.view.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.controller.GameController
import pt.iade.ei.gamestore.model.Game
import pt.iade.ei.gamestore.view.ui.components.GameDetailCard
import pt.iade.ei.gamestore.view.ui.components.ItemCard

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gameId = intent.getIntExtra("gameId", -1)
        val game = GameController.getSampleGames().find { it.id == gameId }

        setContent {
            if (game != null) {
                GameDetailScreen(game = game, onBack = { finish() })
            } else {
                ErrorScreen("Jogo não recebido.")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(game: Game, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            Box(modifier = Modifier.fillMaxWidth()) {
                // 🔙 Ícone de voltar
                IconButton(
                    onClick = onBack,
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_back),
                        contentDescription = "Voltar",
                        modifier = Modifier.size(24.dp)
                    )
                }

                // 🕹️ Nome do jogo centralizado
                Text(
                    text = game.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.align(Alignment.Center)
                )

                // ❤️ Ícone de favorito
                IconButton(
                    onClick = { /* ação futura */ },
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_heart),
                        contentDescription = "Favorito",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                GameDetailCard(game = game)
            }

            item {
                Text(
                    text = "Purchasable Items",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 8.dp)
                )
            }

            items(game.items) { item ->
                ItemCard(item = item)
            }
        }
    }
}

@Composable
fun ErrorScreen(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(message)
    }
}
