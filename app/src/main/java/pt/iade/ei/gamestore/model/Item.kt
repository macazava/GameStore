package pt.iade.ei.gamestore.model

data class Item(
    val id: Int,
    val name: String,
    val imageResId: Int,
    val description: String,
    val price: Double
)