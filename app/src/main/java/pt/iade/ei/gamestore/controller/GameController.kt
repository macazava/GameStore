package pt.iade.ei.gamestore.controller

import pt.iade.ei.gamestore.model.Game
import pt.iade.ei.gamestore.model.Item
import pt.iade.ei.gamestore.R

object GameController {

    fun getSampleGames(): List<Game> {
        val simsItems = listOf(
            Item(1,"Cottage Living",R.drawable.expansionpackcottageliving_itemimage,"The Sims 4 Cottage Living oferece uma experiência campestre com animais, cultivo de alimentos frescos e uma comunidade unida. Interage com vacas e galinhas, cultiva vegetais e explora a aldeia para novas aventuras rurais.", 39.99),
            Item(2, "Fashion Street", R.drawable.kitfashionstreet_itemimage, "Fashion Street é um kit de moda para The Sims 4 que adiciona roupas e acessórios inspirados na cultura urbana de Mumbai. Com cores vivas, padrões tradicionais e silhuetas modernas, permite criar looks únicos e expressivos para os teus Sims.", 4.99),
            Item(3, "Blooming Rooms", R.drawable.kitbloomingrooms_itemimage, "Blooming Rooms é um kit de decoração para The Sims 4 que adiciona plantas e elementos naturais ao lar dos Sims. Com uma variedade de vasos, folhagens e arranjos, permite criar ambientes acolhedores e cheios de vida.", 4.99)
        )

        val horizonItems = listOf(
            Item(4, "Nora Legacy Outfit", R.drawable.outfitnoralegacy_itemimage, "Nora Legacy Outfit é um traje especial que celebra as origens de Aloy na tribo Nora. Oferece um visual icónico e tradicional, permitindo aos jogadores personalizar a protagonista com um estilo marcante e cheio de identidade.", 9.99),
            Item(5, "Elite Hunter Pack", R.drawable.weaponpackelitehunter_itemimage, "Elite Hunter Pack é um conjunto de recursos e equipamentos que ajuda os jogadores a enfrentar máquinas e desafios mais difíceis. Inclui munições, poções e materiais raros, oferecendo vantagens estratégicas para caçadas intensas.", 14.99),
            Item(6, "Burning Shores Expansion", R.drawable.expansionburningshores_itemimage, "Burning Shores é uma expansão que leva Aloy a explorar novas terras devastadas por vulcões e criaturas colossais. Com missões inéditas, ambientes deslumbrantes e inimigos poderosos, expande a aventura principal com conteúdos épicos e desafiadores.", 19.99)
        )

        val animalCrossingItems = listOf(
            Item(7, "Happy Home Paradise", R.drawable.animalcrossingexpansion_itemimage, "Happy Home Paradise é uma expansão de design onde os jogadores podem criar casas de férias personalizadas para diferentes personagens. Oferece novas ferramentas de decoração e permite explorar a criatividade em ambientes únicos.", 24.99),
            Item(8, "Sanrio Furniture Pack", R.drawable.furniturepacksanriocollaboration_itemimage, "Sanrio Furniture Pack é um conjunto de mobiliário temático inspirado em personagens icónicas como Hello Kitty e My Melody. Adiciona peças adoráveis e coloridas que tornam qualquer ilha mais divertida e charmosa.", 5.99),
            Item(9, "Spring Fashion Bundle", R.drawable.outfitbundlespringfashion_itemimage, "Spring Fashion Bundle é um pacote de roupas sazonais que traz estilos leves e coloridos inspirados na primavera. Permite vestir os personagens com novos conjuntos e acessórios para celebrar a estação.", 3.99)
        )

        return listOf(
            Game(1, "The Sims 4", R.drawable.thesims4_gameimage, "The Sims 4 é um jogo de simulação de vida gratuito onde os jogadores criam e controlam Sims. É possível personalizar personagens e casas, gerir as suas carreiras e relacionamentos, e explorar mundos virtuais repletos de eventos.", simsItems),
            Game(2, "Horizon Forbidden West", R.drawable.horizonforbiddenwest_gameimage, "Horizon Forbidden West é um jogo de ação e aventura em mundo aberto onde os jogadores acompanham Aloy num futuro pós‑apocalíptico. Explora territórios vastos, enfrenta máquinas colossais e descobre segredos que podem salvar a humanidade.", horizonItems),
            Game(3, "Animal Crossing: New Horizons", R.drawable.animalcrossingnewhorizons_gameimage, "Animal Crossing: New Horizons é um jogo de simulação social onde os jogadores criam e personalizam uma ilha paradisíaca. Podem decorar casas, cultivar e interagir com vizinhos, construindo uma comunidade relaxante e divertida.", animalCrossingItems)
        )
    }
}