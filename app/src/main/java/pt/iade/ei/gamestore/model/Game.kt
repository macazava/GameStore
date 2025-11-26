package pt.iade.ei.gamestore.model

data class Game(
    val id: Int,
    val name: String,
    val imageUrl: String, //agora vai ser uma URL falsa
    val description: String,
    val items: List<Item>//Permite carregar os itens compraveis na GameDetailActivity
)