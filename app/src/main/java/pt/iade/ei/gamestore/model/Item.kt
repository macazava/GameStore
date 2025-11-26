package pt.iade.ei.gamestore.model

data class Item(
    val id: Int,
    val name: String,
    val imageUrl: String, //agora vai ser uma URL falsa
    val description: String,
    val price: Double
)
