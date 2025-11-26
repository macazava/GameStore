package pt.iade.ei.gamestore.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.model.Game
import pt.iade.ei.gamestore.controller.GameController
import pt.iade.ei.gamestore.view.GameDetailActivity
import pt.iade.ei.gamestore.view.ui.components.GameCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val games: List<Game> = GameController.getGamesList()

        setContent {
            val context = LocalContext.current
            MainScreen(games = games) { selectedGame ->
                println("Clicado: ${selectedGame.name} com ID ${selectedGame.id}")
                val intent = Intent(context, GameDetailActivity::class.java)
                intent.putExtra("gameId", selectedGame.id)
                context.startActivity(intent)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(games: List<Game>, onGameClick: (Game) -> Unit) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_notification),
                        contentDescription = "Notificações",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Image(
                        painter = painterResource(id = R.drawable.icon_settings),
                        contentDescription = "Definições",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = "PlayBloom", //nome da 'empresa'
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false, // ícone estático
                    onClick = {},     // sem ação
                    icon = {
                        Box(
                            modifier = Modifier
                                .size(32.dp) // espaço maior que o ícone
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)), // fundo suave
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_featured),
                                contentDescription = "Featured",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                    ,
                    label = { Text("Destaque") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.icon_history),
                            contentDescription = "History",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Histórico") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.icon_profile),
                            contentDescription = "Profile",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Perfil") }
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(games) { game ->
                GameCard(game = game, onClick = { onGameClick(game) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    val sampleGames = GameController.getGamesList()
    MainScreen(games = sampleGames, onGameClick = {})
}
