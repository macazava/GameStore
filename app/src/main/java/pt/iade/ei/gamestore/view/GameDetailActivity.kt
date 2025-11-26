package pt.iade.ei.gamestore.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import pt.iade.ei.gamestore.controller.GameController
import pt.iade.ei.gamestore.model.Game
import pt.iade.ei.gamestore.view.ui.components.GameDetailCard
import pt.iade.ei.gamestore.view.ui.components.ItemCard
import pt.iade.ei.gamestore.view.ui.components.PurchaseBottomSheet
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.model.Item

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Proteção extra contra null ou ID inválido
        val gameId = intent?.getIntExtra("gameId", -1) ?: -1
        val game = GameController.getSampleGames().find { it.id == gameId }

        setContent {
            if (game != null) {
                GameDetailScreen(game = game, onBack = { finish() })
            } else {
                ErrorScreen("Jogo não recebido ou ID inválido.")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(game: Game, onBack: () -> Unit) {
    var itemSelecionado by remember { mutableStateOf<Item?>(null) }

    if (itemSelecionado != null) {
        PurchaseBottomSheet(
            item = itemSelecionado!!,
            aoFechar = { itemSelecionado = null }
        )
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Ícone de voltar
                IconButton(onClick = onBack) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_back),
                        contentDescription = "Voltar",
                        modifier = Modifier.size(24.dp)
                    )
                }

                // Nome do jogo, alinhado à esquerda após a seta
                Text(
                    text = game.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f) // ocupa espaço restante
                )

                // Ícone de favorito à direita
                IconButton(onClick = { /* ação futura */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_heart),
                        contentDescription = "Favorito",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    )
    { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            item {
                GameDetailCard(game = game)
            }

            item {
                Text(
                    text = "Itens Compráveis",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 8.dp)
                )
            }

            items(game.items) { item ->
                ItemCard(item = item, aoClicar = { itemSelecionado = item })
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

@Preview(showBackground = true)
@Composable
fun PreviewGameDetailScreen() {
    val sampleGame = GameController.getSampleGames().first()
    GameDetailScreen(game = sampleGame, onBack = {})
}
