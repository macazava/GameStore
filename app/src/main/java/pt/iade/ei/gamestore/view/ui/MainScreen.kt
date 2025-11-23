package pt.iade.ei.gamestore.view.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore.R
import pt.iade.ei.gamestore.model.Game
import pt.iade.ei.gamestore.controller.GameController
import pt.iade.ei.gamestore.view.ui.components.GameCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//esta tela foi criada para ser chamada diretamente na MainActivity (porque não tenho a certeza se podia criar como tal uma screen na mainactivity)
fun MainScreen(games: List<Game>, onGameClick: (Game) -> Unit) {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp)) // espaço acima

                //Ícones alinhados à direita
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

                Spacer(modifier = Modifier.height(50.dp)) // espaço entre ícones e título

                //Nome da empresa alinhado à esquerda
                Text(
                    text = "PlayBloom",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(16.dp)) // espaço abaixo
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.icon_featured),
                            contentDescription = "Featured",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Featured") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.icon_history),
                            contentDescription = "History",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("History") }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.icon_profile),
                            contentDescription = "Profile",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Profile") }
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
    val sampleGames = GameController.getSampleGames()
    MainScreen(games = sampleGames, onGameClick = {})
}