    package com.example.pokemonapp.models

    import com.example.pokemonapp.R


    data class Pokemon (
        val id: Int,
        val name: String,
        val type: String,
        val imageRes: Int,
        val description: String,
        val curiosities: String,
        var isFavorite: Boolean = false
    )

    val pokemonList = listOf(
        Pokemon(
            id = 1,
            name = "Pikachu",
            type = "Electric",
            imageRes = R.drawable.pikachu,
            description = "Pikachu é um Pokémon do tipo Elétrico conhecido por ser a mascote da franquia.",
            curiosities = "Pikachu armazena eletricidade em suas bochechas e a usa para se defender."
        ),
        Pokemon(
            id = 2,
            name = "Charmander",
            type = "Fire",
            imageRes = R.drawable.charmander,
            description = "Charmander é um Pokémon do tipo Fogo, facilmente reconhecido por sua chama na cauda.",
            curiosities = "Se a chama de sua cauda apagar, é dito que o Charmander não sobreviverá."
        ),
        Pokemon(
            id = 3,
            name = "Bulbasaur",
            type = "Grass/Poison",
            imageRes = R.drawable.bulbasaur,
            description = "Bulbasaur é um Pokémon do tipo Grama/Veneno que carrega uma semente nas costas.",
            curiosities = "A semente nas costas de Bulbasaur cresce conforme ele ganha experiência."
        ),
        Pokemon(
            id = 4,
            name = "Squirtle",
            type = "Water",
            imageRes = R.drawable.squirtle,
            description = "Squirtle é um Pokémon do tipo Água conhecido por sua habilidade de disparar água.",
            curiosities = "Sua carapaça protege de ataques e ajuda na natação."
        ),
        Pokemon(
            id = 5,
            name = "Jigglypuff",
            type = "Normal/Fairy",
            imageRes = R.drawable.jigglypuff,
            description = "Jigglypuff é um Pokémon que usa sua voz encantadora para colocar inimigos para dormir.",
            curiosities = "Seu corpo flexível permite que infle como um balão."
        ),
        Pokemon(
            id = 6,
            name = "Meowth",
            type = "Normal",
            imageRes = R.drawable.meowth,
            description = "Meowth é conhecido por sua obsessão por moedas brilhantes.",
            curiosities = "Pode andar sobre duas patas, o que é incomum para um Pokémon."
        ),
        Pokemon(
            id = 7,
            name = "Psyduck",
            type = "Water",
            imageRes = R.drawable.psyduck,
            description = "Psyduck é um Pokémon confuso que sofre constantemente de dores de cabeça.",
            curiosities = "Quando suas dores de cabeça aumentam, libera poderes psíquicos."
        ),
        Pokemon(
            id = 8,
            name = "Snorlax",
            type = "Normal",
            imageRes = R.drawable.snorlax,
            description = "Snorlax é conhecido por dormir quase o tempo todo.",
            curiosities = "Quando acordado, consome grandes quantidades de comida."
        ),
        Pokemon(
            id = 9,
            name = "Eevee",
            type = "Normal",
            imageRes = R.drawable.eevee,
            description = "Eevee é um Pokémon com grande potencial evolutivo.",
            curiosities = "Pode evoluir para diferentes tipos, dependendo do ambiente e condições."
        ),
        Pokemon(
            id = 10,
            name = "Vaporeon",
            type = "Water",
            imageRes = R.drawable.vaporeon,
            description = "Vaporeon é uma evolução de Eevee com afinidade pelo elemento água.",
            curiosities = "É capaz de se dissolver na água para se esconder."
        ),
        Pokemon(
            id = 11,
            name = "Flareon",
            type = "Fire",
            imageRes = R.drawable.flareon,
            description = "Flareon é a evolução de Eevee que manipula fogo.",
            curiosities = "Armazena calor em seu corpo e pode expelir fogo intenso."
        ),
        Pokemon(
            id = 12,
            name = "Jolteon",
            type = "Electric",
            imageRes = R.drawable.jolteon,
            description = "Jolteon é a evolução elétrica de Eevee.",
            curiosities = "Seu pelo gera eletricidade estática que pode ser liberada em ataques."
        ),
        Pokemon(
            id = 13,
            name = "Gengar",
            type = "Ghost/Poison",
            imageRes = R.drawable.gengar,
            description = "Gengar é um Pokémon que adora pregar peças assustadoras.",
            curiosities = "É dito que sua presença faz a temperatura cair."
        ),
        Pokemon(
            id = 14,
            name = "Machop",
            type = "Fighting",
            imageRes = R.drawable.machop,
            description = "Machop é um Pokémon forte e dedicado a treinos físicos.",
            curiosities = "É capaz de erguer objetos 10 vezes seu peso."
        ),
        Pokemon(
            id = 15,
            name = "Magikarp",
            type = "Water",
            imageRes = R.drawable.magikarp,
            description = "Magikarp é famoso por sua fraqueza, mas pode evoluir para Gyarados.",
            curiosities = "Mesmo sendo fraco, pode pular grandes distâncias."
        ),
        Pokemon(
            id = 16,
            name = "Gyarados",
            type = "Water/Flying",
            imageRes = R.drawable.gyarados,
            description = "Gyarados é a evolução feroz de Magikarp.",
            curiosities = "Sua raiva é temida, e destrói tudo ao seu redor quando enraivecido."
        ),
        Pokemon(
            id = 17,
            name = "Lapras",
            type = "Water/Ice",
            imageRes = R.drawable.lapras,
            description = "Lapras é um Pokémon gentil que gosta de carregar pessoas em seu casco.",
            curiosities = "É capaz de entender a linguagem humana."
        ),
        Pokemon(
            id = 18,
            name = "Ditto",
            type = "Normal",
            imageRes = R.drawable.ditto,
            description = "Ditto pode se transformar em qualquer outro Pokémon.",
            curiosities = "Pode replicar a aparência, mas às vezes mantém sua expressão facial característica."
        ),
        Pokemon(
            id = 19,
            name = "Dragonite",
            type = "Dragon/Flying",
            imageRes = R.drawable.dragonite,
            description = "Dragonite é um Pokémon amável e extremamente poderoso.",
            curiosities = "Pode voar ao redor do mundo em apenas 16 horas."
        ),
        Pokemon(
            id = 20,
            name = "Mewtwo",
            type = "Psychic",
            imageRes = R.drawable.mewtwo,
            description = "Mewtwo é um Pokémon lendário criado por engenharia genética.",
            curiosities = "É considerado um dos Pokémon mais poderosos do mundo."
        )
    )
