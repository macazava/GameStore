package pt.iade.ei.gamestore.model

data class Game(
    val id: Int,
    val name: String,
    val imageResId: Int,
    val description: String,
    val items: List<Item>
)