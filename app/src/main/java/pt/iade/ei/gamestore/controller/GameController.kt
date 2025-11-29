package pt.iade.ei.gamestore.controller

import pt.iade.ei.gamestore.model.Game
import pt.iade.ei.gamestore.model.Item
import pt.iade.ei.gamestore.R

object GameController {

    //função de mapeamento de imagens
    fun getImageFromUrl(url: String): Int {
        return when (url) { 
            "https://fake.api/images/thesims4" -> R.drawable.thesims4_gameimage
            "https://fake.api/images/horizonforbiddenwest" -> R.drawable.horizonforbiddenwest_gameimage
            "https://fake.api/images/animalcrossingnewhorizons" -> R.drawable.animalcrossingnewhorizons_gameimage


            "https://fake.api/images/cottageliving" -> R.drawable.expansionpackcottageliving_itemimage
            "https://fake.api/images/fashionstreet" -> R.drawable.kitfashionstreet_itemimage
            "https://fake.api/images/bloomingrooms" -> R.drawable.kitbloomingrooms_itemimage

            "https://fake.api/images/noralegacyoutfit" -> R.drawable.outfitnoralegacy_itemimage
            "https://fake.api/images/elitehunterpack" -> R.drawable.weaponpackelitehunter_itemimage
            "https://fake.api/images/burningshoresexpansion" -> R.drawable.expansionburningshores_itemimage

            "https://fake.api/images/happyhomeparadise" -> R.drawable.animalcrossingexpansion_itemimage
            "https://fake.api/images/sanriofurniturepack" -> R.drawable.furniturepacksanriocollaboration_itemimage
            "https://fake.api/images/springfashionbundle" -> R.drawable.outfitbundlespringfashion_itemimage

            else -> R.drawable.placeholder // imagem default
        }
    }

    // função que devolve a lista de jogos
    fun getGamesList(): List<Game> {
        val simsItems = listOf(
            Item(1,"Cottage Living","https://fake.api/images/cottageliving","The Sims 4 Cottage Living oferece uma experiência campestre com animais, cultivo de alimentos frescos e uma comunidade unida. Interage com vacas e galinhas, cultiva vegetais e explora a aldeia para novas aventuras rurais.", 39.99),
            Item(2, "Fashion Street", "https://fake.api/images/fashionstreet", "Fashion Street é um kit de moda para The Sims 4 que adiciona roupas e acessórios inspirados na cultura urbana de Mumbai. Com cores vivas, padrões tradicionais e silhuetas modernas, permite criar looks únicos e expressivos para os teus Sims.", 4.99),
            Item(3, "Blooming Rooms", "https://fake.api/images/bloomingrooms", "Blooming Rooms é um kit de decoração para The Sims 4 que adiciona plantas e elementos naturais ao lar dos Sims. Com uma variedade de vasos, folhagens e arranjos, permite criar ambientes acolhedores e cheios de vida.", 4.99)
        )

        val horizonItems = listOf(
            Item(4, "Nora Legacy Outfit", "https://fake.api/images/noralegacyoutfit", "Nora Legacy Outfit é um traje especial que celebra as origens de Aloy na tribo Nora. Oferece um visual icónico e tradicional, permitindo aos jogadores personalizar a protagonista com um estilo marcante e cheio de identidade.", 9.99),
            Item(5, "Elite Hunter Pack", "https://fake.api/images/elitehunterpack", "Elite Hunter Pack é um conjunto de recursos e equipamentos que ajuda os jogadores a enfrentar máquinas e desafios mais difíceis. Inclui munições, poções e materiais raros, oferecendo vantagens estratégicas para caçadas intensas.", 14.99),
            Item(6, "Burning Shores Expansion", "https://fake.api/images/burningshoresexpansion", "Burning Shores é uma expansão que leva Aloy a explorar novas terras devastadas por vulcões e criaturas colossais. Com missões inéditas, ambientes deslumbrantes e inimigos poderosos, expande a aventura principal com conteúdos épicos e desafiadores.", 19.99)
        )

        val animalCrossingItems = listOf(
            Item(7, "Happy Home Paradise", "https://fake.api/images/happyhomeparadise", "Happy Home Paradise é uma expansão de design onde os jogadores podem criar casas de férias personalizadas para diferentes personagens. Oferece novas ferramentas de decoração e permite explorar a criatividade em ambientes únicos.", 24.99),
            Item(8, "Sanrio Furniture Pack", "https://fake.api/images/sanriofurniturepack", "Sanrio Furniture Pack é um conjunto de mobiliário temático inspirado em personagens icónicas como Hello Kitty e My Melody. Adiciona peças adoráveis e coloridas que tornam qualquer ilha mais divertida e charmosa.", 5.99),
            Item(9, "Spring Fashion Bundle", "https://fake.api/images/springfashionbundle", "Spring Fashion Bundle é um pacote de roupas sazonais que traz estilos leves e coloridos inspirados na primavera. Permite vestir os personagens com novos conjuntos e acessórios para celebrar a estação.", 3.99)
        )

        return listOf(
            Game(1, "The Sims 4", "https://fake.api/images/thesims4", "The Sims 4 é um jogo de simulação de vida gratuito onde os jogadores criam e controlam Sims. É possível personalizar personagens e casas, gerir as suas carreiras e relacionamentos, e explorar mundos virtuais repletos de eventos.", simsItems),
            Game(2, "Horizon Forbidden West", "https://fake.api/images/horizonforbiddenwest", "Horizon Forbidden West é um jogo de ação e aventura em mundo aberto onde os jogadores acompanham Aloy num futuro pós‑apocalíptico. Explora territórios vastos, enfrenta máquinas colossais e descobre segredos que podem salvar a humanidade.", horizonItems),
            Game(3, "Animal Crossing: New Horizons", "https://fake.api/images/animalcrossingnewhorizons", "Animal Crossing: New Horizons é um jogo de simulação social onde os jogadores criam e personalizam uma ilha paradisíaca. Podem decorar casas, cultivar e interagir com vizinhos, construindo uma comunidade relaxante e divertida.", animalCrossingItems)
        )
    }
}

