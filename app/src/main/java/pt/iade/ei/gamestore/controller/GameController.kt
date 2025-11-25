package pt.iade.ei.gamestore.controller

import pt.iade.ei.gamestore.model.Game
import pt.iade.ei.gamestore.model.Item
import pt.iade.ei.gamestore.R

object GameController {

    fun getSampleGames(): List<Game> {
        val simsItems = listOf(
            Item(1,"Cottage Living",R.drawable.expansionpackcottageliving_itemimage,"The Sims™ 4 Cottage Living oferece uma experiência campestre com animais, cultivo de alimentos frescos e uma comunidade unida. Interage com vacas e galinhas, cultiva vegetais e explora a aldeia para novas aventuras rurais.", 39.99),
            Item(2, "Fashion Street", R.drawable.kitfashionstreet_itemimage, "Roupas urbanas inspiradas em Mumbai.", 4.99),
            Item(3, "Blooming Rooms", R.drawable.kitbloomingrooms_itemimage, "Decoração com plantas e ambientes verdes.", 4.99)
        )

        val horizonItems = listOf(
            Item(4, "Nora Legacy Outfit", R.drawable.outfitnoralegacy_itemimage, "Roupa especial inspirada na tribo de Aloy.", 9.99),
            Item(5, "Elite Hunter Pack", R.drawable.weaponpackelitehunter_itemimage, "Armas com atributos melhorados para combate.", 14.99),
            Item(6, "Burning Shores Expansion", R.drawable.expansionburningshores_itemimage, "Continuação da história com novas áreas e inimigos.", 19.99)
        )

        val animalCrossingItems = listOf(
            Item(7, "Happy Home Paradise", R.drawable.animalcrossingexpansion_itemimage, "Cria casas personalizadas para os habitantes.", 24.99),
            Item(8, "Sanrio Furniture Pack", R.drawable.furniturepacksanriocollaboration_itemimage, "Móveis e roupas inspiradas em Hello Kitty.", 5.99),
            Item(9, "Spring Fashion Bundle", R.drawable.outfitbundlespringfashion_itemimage, "Roupas florais e acessórios para primavera.", 3.99)
        )

        return listOf(
            Game(1, "The Sims 4", R.drawable.thesims4_gameimage, "The Sims 4 é um jogo de simulação de vida gratuito onde os jogadores criam e controlam Sims. É possível personalizar personagens e casas, gerir as suas carreiras e relacionamentos, e explorar mundos virtuais repletos de eventos.", simsItems),
            Game(2, "Horizon Forbidden West", R.drawable.horizonforbiddenwest_gameimage, "Ação e exploração com protagonista feminina corajosa.", horizonItems),
            Game(3, "Animal Crossing: New Horizons", R.drawable.animalcrossingnewhorizons_gameimage, "Cria e decora a tua ilha com amigos adoráveis.", animalCrossingItems)
        )
    }
}