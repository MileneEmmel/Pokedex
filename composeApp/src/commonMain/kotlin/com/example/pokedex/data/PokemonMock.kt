package com.example.pokedex.data

object PokemonMock {

    val pokedex = listOf(
        Pokemon(
            id = 1,
            name = "bulbasaur",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            types = listOf("grass", "poison"),
            height = 0.7,
            weight = 6.9,
            abilities = listOf("overgrow", "chlorophyll"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("fire", "psychic", "flying", "ice"),
            evolutions = listOf("bulbasaur", "ivysaur", "venusaur"),
            stats = listOf(
                PokemonStat("hp", 45), PokemonStat("attack", 49),
                PokemonStat("defense", 49), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 65), PokemonStat("speed", 45)
            ),
            description = "Bulbasaur carrega uma semente em suas costas desde o nascimento, que cresce com ele."
        ),
        Pokemon(
            id = 2,
            name = "ivysaur",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
            types = listOf("grass", "poison"),
            height = 1.0,
            weight = 13.0,
            abilities = listOf("overgrow", "chlorophyll"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("fire", "psychic", "flying", "ice"),
            evolutions = listOf("bulbasaur", "ivysaur", "venusaur"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 62),
                PokemonStat("defense", 63), PokemonStat("special-attack", 80),
                PokemonStat("special-defense", 80), PokemonStat("speed", 60)
            ),
            description = "O bulbo em suas costas cresce absorvendo nutrientes e muita luz solar."
        ),
        Pokemon(
            id = 3,
            name = "venusaur",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png",
            types = listOf("grass", "poison"),
            height = 2.0,
            weight = 100.0,
            abilities = listOf("overgrow", "chlorophyll"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("fire", "psychic", "flying", "ice"),
            evolutions = listOf("bulbasaur", "ivysaur", "venusaur"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 82),
                PokemonStat("defense", 83), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 100), PokemonStat("speed", 80)
            ),
            description = "A flor em suas costas libera um aroma que acalma as emoções e traz paz ao ambiente."
        ),
        Pokemon(
            id = 4,
            name = "charmander",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
            types = listOf("fire"),
            height = 0.6,
            weight = 8.5,
            abilities = listOf("blaze", "solar-power"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("water", "ground", "rock"),
            evolutions = listOf("charmander", "charmeleon", "charizard"),
            stats = listOf(
                PokemonStat("hp", 39), PokemonStat("attack", 52),
                PokemonStat("defense", 43), PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 50), PokemonStat("speed", 65)
            ),
            description = "Charmander possui uma chama na ponta da cauda que indica sua vitalidade e emoções."
        ),
        Pokemon(
            id = 5,
            name = "charmeleon",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png",
            types = listOf("fire"),
            height = 1.1,
            weight = 19.0,
            abilities = listOf("blaze", "solar-power"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("water", "ground", "rock"),
            evolutions = listOf("charmander", "charmeleon", "charizard"),
            stats = listOf(
                PokemonStat("hp", 58), PokemonStat("attack", 64),
                PokemonStat("defense", 58), PokemonStat("special-attack", 80),
                PokemonStat("special-defense", 65), PokemonStat("speed", 80)
            ),
            description = "Charmeleon é impetuoso e possui garras afiadas que usa em suas exibições de poder."
        ),
        Pokemon(
            id = 6,
            name = "charizard",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
            types = listOf("fire", "flying"),
            height = 1.7,
            weight = 90.5,
            abilities = listOf("blaze", "solar-power"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("water", "electric", "rock"),
            evolutions = listOf("charmander", "charmeleon", "charizard"),
            stats = listOf(
                PokemonStat("hp", 78), PokemonStat("attack", 84),
                PokemonStat("defense", 78), PokemonStat("special-attack", 109),
                PokemonStat("special-defense", 85), PokemonStat("speed", 100)
            ),
            description = "Charizard voa alto pelos céus em busca de desafios, mas nunca ataca oponentes mais fracos."
        ),
        Pokemon(
            id = 7,
            name = "squirtle",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
            types = listOf("water"),
            height = 0.5,
            weight = 9.0,
            abilities = listOf("torrent", "rain-dish"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("grass", "electric"),
            evolutions = listOf("squirtle", "wartortle", "blastoise"),
            stats = listOf(
                PokemonStat("hp", 44), PokemonStat("attack", 48),
                PokemonStat("defense", 65), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 64), PokemonStat("speed", 43)
            ),
            description = "Squirtle se protege com seu casco resistente e lança fortes jatos d’água."
        ),
        Pokemon(
            id = 8,
            name = "wartortle",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png",
            types = listOf("water"),
            height = 1.0,
            weight = 22.5,
            abilities = listOf("torrent", "rain-dish"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("grass", "electric"),
            evolutions = listOf("squirtle", "wartortle", "blastoise"),
            stats = listOf(
                PokemonStat("hp", 59), PokemonStat("attack", 63),
                PokemonStat("defense", 80), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 80), PokemonStat("speed", 58)
            ),
            description = "Wartortle possui orelhas peludas e uma cauda que são símbolos de longevidade."
        ),
        Pokemon(
            id = 9,
            name = "blastoise",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
            types = listOf("water"),
            height = 1.6,
            weight = 85.5,
            abilities = listOf("torrent", "rain-dish"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("grass", "electric"),
            evolutions = listOf("squirtle", "wartortle", "blastoise"),
            stats = listOf(
                PokemonStat("hp", 79), PokemonStat("attack", 83),
                PokemonStat("defense", 100), PokemonStat("special-attack", 85),
                PokemonStat("special-defense", 105), PokemonStat("speed", 78)
            ),
            description = "Blastoise possui canhões de água em seu casco que disparam jatos de alta pressão."
        ),
        Pokemon(
            id = 10,
            name = "caterpie",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png",
            types = listOf("bug"),
            height = 0.3,
            weight = 2.9,
            abilities = listOf("shield-dust", "run-away"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "rock"),
            evolutions = listOf("caterpie", "metapod", "butterfree"),
            stats = listOf(
                PokemonStat("hp", 45), PokemonStat("attack", 30),
                PokemonStat("defense", 35), PokemonStat("special-attack", 20),
                PokemonStat("special-defense", 20), PokemonStat("speed", 45)
            ),
            description = "Caterpie usa as antenas em sua cabeça para afastar ameaças com um odor forte."
        ),
        Pokemon(
            id = 11,
            name = "metapod",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/11.png",
            types = listOf("bug"),
            height = 0.7,
            weight = 9.9,
            abilities = listOf("shed-skin"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "rock"),
            evolutions = listOf("caterpie", "metapod", "butterfree"),
            stats = listOf(
                PokemonStat("hp", 50), PokemonStat("attack", 20),
                PokemonStat("defense", 55), PokemonStat("special-attack", 25),
                PokemonStat("special-defense", 25), PokemonStat("speed", 30)
            ),
            description = "Metapod possui uma carapaça rígida e aguarda pacientemente até o momento de evoluir."
        ),
        Pokemon(
            id = 12,
            name = "butterfree",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/12.png",
            types = listOf("bug", "flying"),
            height = 1.1,
            weight = 32.0,
            abilities = listOf("compound-eyes", "tinted-lens"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "rock", "electric", "ice"),
            evolutions = listOf("caterpie", "metapod", "butterfree"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 45),
                PokemonStat("defense", 50), PokemonStat("special-attack", 90),
                PokemonStat("special-defense", 80), PokemonStat("speed", 70)
            ),
            description = "Butterfree coleta néctar de flores com grande habilidade enquanto voa graciosamente."
        ),
        Pokemon(
            id = 13,
            name = "weedle",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png",
            types = listOf("bug", "poison"),
            height = 0.3,
            weight = 3.2,
            abilities = listOf("shield-dust", "run-away"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "rock", "psychic"),
            evolutions = listOf("weedle", "kakuna", "beedrill"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 35),
                PokemonStat("defense", 30), PokemonStat("special-attack", 20),
                PokemonStat("special-defense", 20), PokemonStat("speed", 50)
            ),
            description = "Weedle tem um ferrão venenoso na cabeça que usa para se defender na natureza."
        ),
        Pokemon(
            id = 14,
            name = "kakuna",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/14.png",
            types = listOf("bug", "poison"),
            height = 0.6,
            weight = 10.0,
            abilities = listOf("shed-skin"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "rock", "psychic"),
            evolutions = listOf("weedle", "kakuna", "beedrill"),
            stats = listOf(
                PokemonStat("hp", 45), PokemonStat("attack", 25),
                PokemonStat("defense", 50), PokemonStat("special-attack", 25),
                PokemonStat("special-defense", 25), PokemonStat("speed", 35)
            ),
            description = "Kakuna permanece imóvel em árvores, protegendo-se enquanto se prepara para evoluir."
        ),
        Pokemon(
            id = 15,
            name = "beedrill",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png",
            types = listOf("bug", "poison"),
            height = 1.0,
            weight = 29.5,
            abilities = listOf("swarm", "sniper"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "rock", "psychic"),
            evolutions = listOf("weedle", "kakuna", "beedrill"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 90),
                PokemonStat("defense", 40), PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 80), PokemonStat("speed", 75)
            ),
            description = "Beedrill voa em alta velocidade e é extremamente territorial com sua colmeia."
        ),
        Pokemon(
            id = 16,
            name = "pidgey",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png",
            types = listOf("normal", "flying"),
            height = 0.3,
            weight = 1.8,
            abilities = listOf("keen-eye", "tangled-feet"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "rock", "ice"),
            evolutions = listOf("pidgey", "pidgeotto", "pidgeot"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 45),
                PokemonStat("defense", 40), PokemonStat("special-attack", 35),
                PokemonStat("special-defense", 35), PokemonStat("speed", 56)
            ),
            description = "Pidgey é muito dócil e prefere evitar conflitos, jogando areia para se esconder."
        ),
        Pokemon(
            id = 17,
            name = "pidgeotto",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/17.png",
            types = listOf("normal", "flying"),
            height = 1.1,
            weight = 30.0,
            abilities = listOf("keen-eye", "tangled-feet"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "rock", "ice"),
            evolutions = listOf("pidgey", "pidgeotto", "pidgeot"),
            stats = listOf(
                PokemonStat("hp", 63), PokemonStat("attack", 60),
                PokemonStat("defense", 55), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 50), PokemonStat("speed", 71)
            ),
            description = "Pidgeotto patrulha seu território voando em grandes círculos pelo céu."
        ),
        Pokemon(
            id = 18,
            name = "pidgeot",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png",
            types = listOf("normal", "flying"),
            height = 1.5,
            weight = 39.5,
            abilities = listOf("keen-eye", "tangled-feet"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "rock", "ice"),
            evolutions = listOf("pidgey", "pidgeotto", "pidgeot"),
            stats = listOf(
                PokemonStat("hp", 83), PokemonStat("attack", 80),
                PokemonStat("defense", 75), PokemonStat("special-attack", 70),
                PokemonStat("special-defense", 70), PokemonStat("speed", 101)
            ),
            description = "Pidgeot possui penas maravilhosas e consegue voar a velocidades incrivelmente altas."
        ),
        Pokemon(
            id = 19,
            name = "rattata",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/19.png",
            types = listOf("normal"),
            height = 0.3,
            weight = 3.5,
            abilities = listOf("run-away", "guts"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fighting"),
            evolutions = listOf("rattata", "raticate"),
            stats = listOf(
                PokemonStat("hp", 30), PokemonStat("attack", 56),
                PokemonStat("defense", 35), PokemonStat("special-attack", 25),
                PokemonStat("special-defense", 35), PokemonStat("speed", 72)
            ),
            description = "Rattata é cauteloso e muito resistente, vivendo em praticamente qualquer ambiente."
        ),
        Pokemon(
            id = 20,
            name = "raticate",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/20.png",
            types = listOf("normal"),
            height = 0.7,
            weight = 18.5,
            abilities = listOf("run-away", "guts"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fighting"),
            evolutions = listOf("rattata", "raticate"),
            stats = listOf(
                PokemonStat("hp", 55), PokemonStat("attack", 81),
                PokemonStat("defense", 60), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 70), PokemonStat("speed", 97)
            ),
            description = "Raticate usa seus dentes fortes para roer obstáculos que encontra pelo caminho."
        ),
        Pokemon(
            id = 21,
            name = "spearow",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/21.png",
            types = listOf("normal", "flying"),
            height = 0.3,
            weight = 2.0,
            abilities = listOf("keen-eye", "sniper"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "rock", "ice"),
            evolutions = listOf("spearow", "fearow"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 60),
                PokemonStat("defense", 30), PokemonStat("special-attack", 31),
                PokemonStat("special-defense", 31), PokemonStat("speed", 70)
            ),
            description = "Spearow voa furtivamente e tem um piado muito agudo que pode ser ouvido de longe."
        ),
        Pokemon(
            id = 22,
            name = "fearow",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/22.png",
            types = listOf("normal", "flying"),
            height = 1.2,
            weight = 38.0,
            abilities = listOf("keen-eye", "sniper"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "rock", "ice"),
            evolutions = listOf("spearow", "fearow"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 90),
                PokemonStat("defense", 65), PokemonStat("special-attack", 61),
                PokemonStat("special-defense", 61), PokemonStat("speed", 100)
            ),
            description = "Fearow usa seu longo bico e suas asas largas para pairar nos céus o dia todo."
        ),
        Pokemon(
            id = 23,
            name = "ekans",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/23.png",
            types = listOf("poison"),
            height = 2.0,
            weight = 6.9,
            abilities = listOf("intimidate", "shed-skin"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ground", "psychic"),
            evolutions = listOf("ekans", "arbok"),
            stats = listOf(
                PokemonStat("hp", 35), PokemonStat("attack", 60),
                PokemonStat("defense", 44), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 54), PokemonStat("speed", 55)
            ),
            description = "Ekans se move de forma sorrateira e repousa enrolada para reagir a qualquer direção."
        ),
        Pokemon(
            id = 24,
            name = "arbok",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/24.png",
            types = listOf("poison"),
            height = 3.5,
            weight = 65.0,
            abilities = listOf("intimidate", "shed-skin"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ground", "psychic"),
            evolutions = listOf("ekans", "arbok"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 95),
                PokemonStat("defense", 69), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 79), PokemonStat("speed", 80)
            ),
            description = "Arbok intimida intrusos com o padrão assustador desenhado em seu peito."
        ),
        Pokemon(
            id = 25,
            name = "pikachu",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
            types = listOf("electric"),
            height = 0.4,
            weight = 6.0,
            abilities = listOf("static", "lightning-rod"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ground"),
            evolutions = listOf("pikachu", "raichu"),
            stats = listOf(
                PokemonStat("hp", 35), PokemonStat("attack", 55),
                PokemonStat("defense", 40), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 50), PokemonStat("speed", 90)
            ),
            description = "Pikachu armazena eletricidade em suas bochechas, que estalam quando está alerta."
        ),
        Pokemon(
            id = 26,
            name = "raichu",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/26.png",
            types = listOf("electric"),
            height = 0.8,
            weight = 30.0,
            abilities = listOf("static", "lightning-rod"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ground"),
            evolutions = listOf("pikachu", "raichu"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 90),
                PokemonStat("defense", 55), PokemonStat("special-attack", 90),
                PokemonStat("special-defense", 80), PokemonStat("speed", 110)
            ),
            description = "Raichu descarrega o excesso de eletricidade no solo através de sua cauda longa."
        ),
        Pokemon(
            id = 27,
            name = "sandshrew",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/27.png",
            types = listOf("ground"),
            height = 0.6,
            weight = 12.0,
            abilities = listOf("sand-veil", "sand-rush"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice"),
            evolutions = listOf("sandshrew", "sandslash"),
            stats = listOf(
                PokemonStat("hp", 50), PokemonStat("attack", 75),
                PokemonStat("defense", 85), PokemonStat("special-attack", 20),
                PokemonStat("special-defense", 30), PokemonStat("speed", 40)
            ),
            description = "Sandshrew se enrola como uma bola apertada para se proteger e quicar no chão."
        ),
        Pokemon(
            id = 28,
            name = "sandslash",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/28.png",
            types = listOf("ground"),
            height = 1.0,
            weight = 29.5,
            abilities = listOf("sand-veil", "sand-rush"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice"),
            evolutions = listOf("sandshrew", "sandslash"),
            stats = listOf(
                PokemonStat("hp", 75), PokemonStat("attack", 100),
                PokemonStat("defense", 110), PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 55), PokemonStat("speed", 65)
            ),
            description = "Sandslash usa as garras de suas costas para criar nuvens de poeira como defesa."
        ),
        Pokemon(
            id = 29,
            name = "nidoran-f",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/29.png",
            types = listOf("poison"),
            height = 0.4,
            weight = 7.0,
            abilities = listOf("poison-point", "rivalry", "hustle"),
            gender = "0% M, 100% F",
            weaknesses = listOf("ground", "psychic"),
            evolutions = listOf("nidoran-f", "nidorina", "nidoqueen"),
            stats = listOf(
                PokemonStat("hp", 55), PokemonStat("attack", 47),
                PokemonStat("defense", 52), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 40), PokemonStat("speed", 41)
            ),
            description = "Nidoran♀ possui pequenos chifres venenosos que usa de forma defensiva ao ser acuada."
        ),
        Pokemon(
            id = 30,
            name = "nidorina",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/30.png",
            types = listOf("poison"),
            height = 0.8,
            weight = 20.0,
            abilities = listOf("poison-point", "rivalry", "hustle"),
            gender = "0% M, 100% F",
            weaknesses = listOf("ground", "psychic"),
            evolutions = listOf("nidoran-f", "nidorina", "nidoqueen"),
            stats = listOf(
                PokemonStat("hp", 70), PokemonStat("attack", 62),
                PokemonStat("defense", 67), PokemonStat("special-attack", 55),
                PokemonStat("special-defense", 55), PokemonStat("speed", 56)
            ),
            description = "Nidorina tem um temperamento dócil e vive de forma unida e afetuosa em grupo."
        ),
        Pokemon(
            id = 31,
            name = "nidoqueen",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/31.png",
            types = listOf("poison", "ground"),
            height = 1.3,
            weight = 60.0,
            abilities = listOf("poison-point", "rivalry", "sheer-force"),
            gender = "0% M, 100% F",
            weaknesses = listOf("ground", "psychic", "water", "ice"),
            evolutions = listOf("nidoran-f", "nidorina", "nidoqueen"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 92),
                PokemonStat("defense", 87), PokemonStat("special-attack", 75),
                PokemonStat("special-defense", 85), PokemonStat("speed", 76)
            ),
            description = "Nidoqueen é coberta de escamas duras e protege sua família com sua própria vida."
        ),
        Pokemon(
            id = 32,
            name = "nidoran-m",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/32.png",
            types = listOf("poison"),
            height = 0.5,
            weight = 9.0,
            abilities = listOf("poison-point", "rivalry", "hustle"),
            gender = "100% M, 0% F",
            weaknesses = listOf("ground", "psychic"),
            evolutions = listOf("nidoran-m", "nidorino", "nidoking"),
            stats = listOf(
                PokemonStat("hp", 46), PokemonStat("attack", 57),
                PokemonStat("defense", 40), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 40), PokemonStat("speed", 50)
            ),
            description = "Nidoran♂ capta sons de todas as direções usando suas orelhas grandes e atentas."
        ),
        Pokemon(
            id = 33,
            name = "nidorino",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/33.png",
            types = listOf("poison"),
            height = 0.9,
            weight = 19.5,
            abilities = listOf("poison-point", "rivalry", "hustle"),
            gender = "100% M, 0% F",
            weaknesses = listOf("ground", "psychic"),
            evolutions = listOf("nidoran-m", "nidorino", "nidoking"),
            stats = listOf(
                PokemonStat("hp", 61), PokemonStat("attack", 72),
                PokemonStat("defense", 57), PokemonStat("special-attack", 55),
                PokemonStat("special-defense", 55), PokemonStat("speed", 65)
            ),
            description = "Nidorino se irrita facilmente e usa seu chifre duro como diamante em investidas."
        ),
        Pokemon(
            id = 34,
            name = "nidoking",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/34.png",
            types = listOf("poison", "ground"),
            height = 1.4,
            weight = 62.0,
            abilities = listOf("poison-point", "rivalry", "sheer-force"),
            gender = "100% M, 0% F",
            weaknesses = listOf("ground", "psychic", "water", "ice"),
            evolutions = listOf("nidoran-m", "nidorino", "nidoking"),
            stats = listOf(
                PokemonStat("hp", 81), PokemonStat("attack", 102),
                PokemonStat("defense", 77), PokemonStat("special-attack", 85),
                PokemonStat("special-defense", 75), PokemonStat("speed", 85)
            ),
            description = "Nidoking possui uma cauda incrivelmente forte capaz de derrubar torres metálicas."
        ),
        Pokemon(
            id = 35,
            name = "clefairy",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png",
            types = listOf("fairy"),
            height = 0.6,
            weight = 7.5,
            abilities = listOf("cute-charm", "magic-guard", "friend-guard"),
            gender = "25% M, 75% F",
            weaknesses = listOf("poison", "steel"),
            evolutions = listOf("clefairy", "clefable"),
            stats = listOf(
                PokemonStat("hp", 70), PokemonStat("attack", 45),
                PokemonStat("defense", 48), PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 65), PokemonStat("speed", 35)
            ),
            description = "Clefairy é rara e muito admirada, sendo conhecida por dançar sob a luz do luar."
        ),
        Pokemon(
            id = 36,
            name = "clefable",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/36.png",
            types = listOf("fairy"),
            height = 1.3,
            weight = 40.0,
            abilities = listOf("cute-charm", "magic-guard", "unaware"),
            gender = "25% M, 75% F",
            weaknesses = listOf("poison", "steel"),
            evolutions = listOf("clefairy", "clefable"),
            stats = listOf(
                PokemonStat("hp", 95), PokemonStat("attack", 70),
                PokemonStat("defense", 73), PokemonStat("special-attack", 95),
                PokemonStat("special-defense", 90), PokemonStat("speed", 60)
            ),
            description = "Clefable tem uma audição aguçada, podendo ouvir um alfinete cair a quilômetros."
        ),
        Pokemon(
            id = 37,
            name = "vulpix",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/37.png",
            types = listOf("fire"),
            height = 0.6,
            weight = 9.9,
            abilities = listOf("flash-fire", "drought"),
            gender = "25% M, 75% F",
            weaknesses = listOf("water", "ground", "rock"),
            evolutions = listOf("vulpix", "ninetales"),
            stats = listOf(
                PokemonStat("hp", 38), PokemonStat("attack", 41),
                PokemonStat("defense", 40), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 65), PokemonStat("speed", 65)
            ),
            description = "Vulpix nasce com uma única cauda branca que se divide à medida que cresce."
        ),
        Pokemon(
            id = 38,
            name = "ninetales",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/38.png",
            types = listOf("fire"),
            height = 1.1,
            weight = 19.9,
            abilities = listOf("flash-fire", "drought"),
            gender = "25% M, 75% F",
            weaknesses = listOf("water", "ground", "rock"),
            evolutions = listOf("vulpix", "ninetales"),
            stats = listOf(
                PokemonStat("hp", 73), PokemonStat("attack", 76),
                PokemonStat("defense", 75), PokemonStat("special-attack", 81),
                PokemonStat("special-defense", 100), PokemonStat("speed", 100)
            ),
            description = "Ninetales possui pelagem dourada e é dito que suas nove caudas guardam poderes místicos."
        ),
        Pokemon(
            id = 39,
            name = "jigglypuff",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png",
            types = listOf("normal", "fairy"),
            height = 0.5,
            weight = 5.5,
            abilities = listOf("cute-charm", "competitive", "friend-guard"),
            gender = "25% M, 75% F",
            weaknesses = listOf("poison", "steel"),
            evolutions = listOf("jigglypuff", "wigglytuff"),
            stats = listOf(
                PokemonStat("hp", 115), PokemonStat("attack", 45),
                PokemonStat("defense", 20), PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 25), PokemonStat("speed", 20)
            ),
            description = "Jigglypuff infla seus pulmões e canta uma canção de ninar irresistível."
        ),
        Pokemon(
            id = 40,
            name = "wigglytuff",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/40.png",
            types = listOf("normal", "fairy"),
            height = 1.0,
            weight = 12.0,
            abilities = listOf("cute-charm", "competitive", "frisk"),
            gender = "25% M, 75% F",
            weaknesses = listOf("poison", "steel"),
            evolutions = listOf("jigglypuff", "wigglytuff"),
            stats = listOf(
                PokemonStat("hp", 140), PokemonStat("attack", 70),
                PokemonStat("defense", 45), PokemonStat("special-attack", 85),
                PokemonStat("special-defense", 50), PokemonStat("speed", 45)
            ),
            description = "Wigglytuff tem pelo macio e luxuoso, e pode inflar seu corpo para intimidar adversários."
        ),
        Pokemon(
            id = 41,
            name = "zubat",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/41.png",
            types = listOf("poison", "flying"),
            height = 0.8,
            weight = 7.5,
            abilities = listOf("inner-focus", "infiltrator"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "ice", "psychic", "rock"),
            evolutions = listOf("zubat", "golbat"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 45),
                PokemonStat("defense", 35), PokemonStat("special-attack", 30),
                PokemonStat("special-defense", 40), PokemonStat("speed", 55)
            ),
            description = "Zubat evita a luz solar e usa ondas ultrassônicas para voar e explorar cavernas escuras."
        ),
        Pokemon(
            id = 42,
            name = "golbat",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/42.png",
            types = listOf("poison", "flying"),
            height = 1.6,
            weight = 55.0,
            abilities = listOf("inner-focus", "infiltrator"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "ice", "psychic", "rock"),
            evolutions = listOf("zubat", "golbat"),
            stats = listOf(
                PokemonStat("hp", 75), PokemonStat("attack", 80),
                PokemonStat("defense", 70), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 75), PokemonStat("speed", 90)
            ),
            description = "Golbat voa silenciosamente na calada da noite e tem presas incrivelmente afiadas."
        ),
        Pokemon(
            id = 43,
            name = "oddish",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/43.png",
            types = listOf("grass", "poison"),
            height = 0.5,
            weight = 5.4,
            abilities = listOf("chlorophyll", "run-away"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "ice", "psychic"),
            evolutions = listOf("oddish", "gloom", "vileplume"),
            stats = listOf(
                PokemonStat("hp", 45), PokemonStat("attack", 50),
                PokemonStat("defense", 55), PokemonStat("special-attack", 75),
                PokemonStat("special-defense", 65), PokemonStat("speed", 30)
            ),
            description = "Oddish se enterra no solo durante o dia e caminha pelas noites iluminadas pela lua."
        ),
        Pokemon(
            id = 44,
            name = "gloom",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/44.png",
            types = listOf("grass", "poison"),
            height = 0.8,
            weight = 8.6,
            abilities = listOf("chlorophyll", "stench"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "ice", "psychic"),
            evolutions = listOf("oddish", "gloom", "vileplume"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 65),
                PokemonStat("defense", 70), PokemonStat("special-attack", 85),
                PokemonStat("special-defense", 75), PokemonStat("speed", 40)
            ),
            description = "Gloom libera um aroma forte para afastar aproximações indesejadas."
        ),
        Pokemon(
            id = 45,
            name = "vileplume",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/45.png",
            types = listOf("grass", "poison"),
            height = 1.2,
            weight = 18.6,
            abilities = listOf("chlorophyll", "effect-spore"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "ice", "psychic"),
            evolutions = listOf("oddish", "gloom", "vileplume"),
            stats = listOf(
                PokemonStat("hp", 75), PokemonStat("attack", 80),
                PokemonStat("defense", 85), PokemonStat("special-attack", 110),
                PokemonStat("special-defense", 90), PokemonStat("speed", 50)
            ),
            description = "Vileplume tem pétalas que dispersam pólen de alergia intensa."
        ),
        Pokemon(
            id = 46,
            name = "paras",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/46.png",
            types = listOf("bug", "grass"),
            height = 0.3,
            weight = 5.4,
            abilities = listOf("effect-spore", "dry-skin"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "bug", "ice", "poison", "rock"),
            evolutions = listOf("paras", "parasect"),
            stats = listOf(
                PokemonStat("hp", 35), PokemonStat("attack", 70),
                PokemonStat("defense", 55), PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 55), PokemonStat("speed", 25)
            ),
            description = "Paras tem cogumelos mágicos crescendo em suas costas que absorvem nutrientes."
        ),
        Pokemon(
            id = 47,
            name = "parasect",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/47.png",
            types = listOf("bug", "grass"),
            height = 1.0,
            weight = 29.5,
            abilities = listOf("effect-spore", "dry-skin"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "bug", "ice", "poison", "rock"),
            evolutions = listOf("paras", "parasect"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 95),
                PokemonStat("defense", 80), PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 80), PokemonStat("speed", 30)
            ),
            description = "O cogumelo em suas costas cresceu tanto que passou a controlar o corpo do inseto."
        ),
        Pokemon(
            id = 48,
            name = "venonat",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/48.png",
            types = listOf("bug", "poison"),
            height = 1.0,
            weight = 30.0,
            abilities = listOf("compound-eyes", "tinted-lens"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "psychic", "rock"),
            evolutions = listOf("venonat", "venomoth"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 55),
                PokemonStat("defense", 50), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 55), PokemonStat("speed", 45)
            ),
            description = "Venonat tem olhos compostos que funcionam como radares para caçar no escuro."
        ),
        Pokemon(
            id = 49,
            name = "venomoth",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/49.png",
            types = listOf("bug", "poison"),
            height = 1.5,
            weight = 12.5,
            abilities = listOf("shield-dust", "tinted-lens"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "psychic", "rock"),
            evolutions = listOf("venonat", "venomoth"),
            stats = listOf(
                PokemonStat("hp", 70), PokemonStat("attack", 65),
                PokemonStat("defense", 60), PokemonStat("special-attack", 90),
                PokemonStat("special-defense", 75), PokemonStat("speed", 90)
            ),
            description = "Espalha escamas finas como poeira a cada bater de suas asas graciosas."
        ),
        Pokemon(
            id = 50,
            name = "diglett",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/50.png",
            types = listOf("ground"),
            height = 0.2,
            weight = 0.8,
            abilities = listOf("sand-veil", "arena-trap"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice"),
            evolutions = listOf("diglett", "dugtrio"),
            stats = listOf(
                PokemonStat("hp", 10), PokemonStat("attack", 55),
                PokemonStat("defense", 25), PokemonStat("special-attack", 35),
                PokemonStat("special-defense", 45), PokemonStat("speed", 95)
            ),
            description = "Diglett vive no subsolo e suas escavações deixam a terra perfeita para o plantio."
        ),
        Pokemon(
            id = 51,
            name = "dugtrio",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/51.png",
            types = listOf("ground"),
            height = 0.7,
            weight = 33.3,
            abilities = listOf("sand-veil", "arena-trap"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice"),
            evolutions = listOf("diglett", "dugtrio"),
            stats = listOf(
                PokemonStat("hp", 35), PokemonStat("attack", 100),
                PokemonStat("defense", 50), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 70), PokemonStat("speed", 120)
            ),
            description = "Três Digletts que cavam em sincronia perfeita, alcançando grandes profundidades."
        ),
        Pokemon(
            id = 52,
            name = "meowth",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/52.png",
            types = listOf("normal"),
            height = 0.4,
            weight = 4.2,
            abilities = listOf("pickup", "technician"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fighting"),
            evolutions = listOf("meowth", "persian"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 45),
                PokemonStat("defense", 35), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 40), PokemonStat("speed", 90)
            ),
            description = "Meowth é fascinado por objetos brilhantes e redondos."
        ),
        Pokemon(
            id = 53,
            name = "persian",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/53.png",
            types = listOf("normal"),
            height = 1.0,
            weight = 32.0,
            abilities = listOf("limber", "technician"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fighting"),
            evolutions = listOf("meowth", "persian"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 70),
                PokemonStat("defense", 60), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 65), PokemonStat("speed", 115)
            ),
            description = "Persian tem uma atitude orgulhosa e é muito ágil."
        ),
        Pokemon(
            id = 54,
            name = "psyduck",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/54.png",
            types = listOf("water"),
            height = 0.8,
            weight = 19.6,
            abilities = listOf("damp", "cloud-nine"),
            gender = "50% M, 50% F",
            weaknesses = listOf("grass", "electric"),
            evolutions = listOf("psyduck", "golduck"),
            stats = listOf(
                PokemonStat("hp", 50), PokemonStat("attack", 52),
                PokemonStat("defense", 48), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 50), PokemonStat("speed", 55)
            ),
            description = "Psyduck sofre com dores de cabeça constantes que liberam poderes psíquicos."
        ),
        Pokemon(
            id = 55,
            name = "golduck",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/55.png",
            types = listOf("water"),
            height = 1.7,
            weight = 76.6,
            abilities = listOf("damp", "cloud-nine"),
            gender = "50% M, 50% F",
            weaknesses = listOf("grass", "electric"),
            evolutions = listOf("psyduck", "golduck"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 82),
                PokemonStat("defense", 78), PokemonStat("special-attack", 95),
                PokemonStat("special-defense", 80), PokemonStat("speed", 85)
            ),
            description = "Um nadador exímio que é muitas vezes confundido com o mítico Kappa."
        ),
        Pokemon(
            id = 56,
            name = "mankey",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/56.png",
            types = listOf("fighting"),
            height = 0.5,
            weight = 28.0,
            abilities = listOf("vital-spirit", "anger-point"),
            gender = "50% M, 50% F",
            weaknesses = listOf("flying", "psychic", "fairy"),
            evolutions = listOf("mankey", "primeape"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 80),
                PokemonStat("defense", 35), PokemonStat("special-attack", 35),
                PokemonStat("special-defense", 45), PokemonStat("speed", 70)
            ),
            description = "Mankey se irrita por qualquer motivo e ataca em bando."
        ),
        Pokemon(
            id = 57,
            name = "primeape",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/57.png",
            types = listOf("fighting"),
            height = 1.0,
            weight = 32.0,
            abilities = listOf("vital-spirit", "anger-point"),
            gender = "50% M, 50% F",
            weaknesses = listOf("flying", "psychic", "fairy"),
            evolutions = listOf("mankey", "primeape"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 105),
                PokemonStat("defense", 60), PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 70), PokemonStat("speed", 95)
            ),
            description = "Sempre furioso. Seus ataques são impetuosos e implacáveis."
        ),
        Pokemon(
            id = 58,
            name = "growlithe",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/58.png",
            types = listOf("fire"),
            height = 0.7,
            weight = 19.0,
            abilities = listOf("intimidate", "flash-fire"),
            gender = "75% M, 25% F",
            weaknesses = listOf("water", "ground", "rock"),
            evolutions = listOf("growlithe", "arcanine"),
            stats = listOf(
                PokemonStat("hp", 55), PokemonStat("attack", 70),
                PokemonStat("defense", 45), PokemonStat("special-attack", 70),
                PokemonStat("special-defense", 50), PokemonStat("speed", 60)
            ),
            description = "Growlithe é valente e leal, defendendo seu território com bravura."
        ),
        Pokemon(
            id = 59,
            name = "arcanine",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/59.png",
            types = listOf("fire"),
            height = 1.9,
            weight = 155.0,
            abilities = listOf("intimidate", "flash-fire"),
            gender = "75% M, 25% F",
            weaknesses = listOf("water", "ground", "rock"),
            evolutions = listOf("growlithe", "arcanine"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 110),
                PokemonStat("defense", 80), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 80), PokemonStat("speed", 95)
            ),
            description = "Sua velocidade majestosa o faz parecer que está voando."
        ),
        Pokemon(
            id = 60,
            name = "poliwag",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/60.png",
            types = listOf("water"),
            height = 0.6,
            weight = 12.4,
            abilities = listOf("water-absorb", "damp"),
            gender = "50% M, 50% F",
            weaknesses = listOf("grass", "electric"),
            evolutions = listOf("poliwag", "poliwhirl", "poliwrath"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 50),
                PokemonStat("defense", 40), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 40), PokemonStat("speed", 90)
            ),
            description = "A espiral em sua barriga são seus órgãos internos visíveis através da pele fina."
        ),
        Pokemon(
            id = 61,
            name = "poliwhirl",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/61.png",
            types = listOf("water"),
            height = 1.0,
            weight = 20.0,
            abilities = listOf("water-absorb", "damp"),
            gender = "50% M, 50% F",
            weaknesses = listOf("grass", "electric"),
            evolutions = listOf("poliwag", "poliwhirl", "poliwrath"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 65),
                PokemonStat("defense", 65), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 50), PokemonStat("speed", 90)
            ),
            description = "Consegue viver fora da água, mas prefere rios calmos."
        ),
        Pokemon(
            id = 62,
            name = "poliwrath",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/62.png",
            types = listOf("water", "fighting"),
            height = 1.3,
            weight = 54.0,
            abilities = listOf("water-absorb", "damp"),
            gender = "50% M, 50% F",
            weaknesses = listOf("grass", "electric", "flying", "psychic", "fairy"),
            evolutions = listOf("poliwag", "poliwhirl", "poliwrath"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 85),
                PokemonStat("defense", 95), PokemonStat("special-attack", 70),
                PokemonStat("special-defense", 90), PokemonStat("speed", 70)
            ),
            description = "Nadador exímio e lutador potente com músculos invejáveis."
        ),
        Pokemon(
            id = 63,
            name = "abra",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/63.png",
            types = listOf("psychic"),
            height = 0.9,
            weight = 19.5,
            abilities = listOf("synchronize", "inner-focus"),
            gender = "75% M, 25% F",
            weaknesses = listOf("bug", "ghost", "dark"),
            evolutions = listOf("abra", "kadabra", "alakazam"),
            stats = listOf(
                PokemonStat("hp", 25), PokemonStat("attack", 20),
                PokemonStat("defense", 15), PokemonStat("special-attack", 105),
                PokemonStat("special-defense", 55), PokemonStat("speed", 90)
            ),
            description = "Dorme 18 horas por dia e usa teletransporte instintivo se atacado."
        ),
        Pokemon(
            id = 64,
            name = "kadabra",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/64.png",
            types = listOf("psychic"),
            height = 1.3,
            weight = 56.5,
            abilities = listOf("synchronize", "inner-focus"),
            gender = "75% M, 25% F",
            weaknesses = listOf("bug", "ghost", "dark"),
            evolutions = listOf("abra", "kadabra", "alakazam"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 35),
                PokemonStat("defense", 30), PokemonStat("special-attack", 120),
                PokemonStat("special-defense", 70), PokemonStat("speed", 105)
            ),
            description = "Emite ondas psíquicas fortes que podem quebrar máquinas por perto."
        ),
        Pokemon(
            id = 65,
            name = "alakazam",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/65.png",
            types = listOf("psychic"),
            height = 1.5,
            weight = 48.0,
            abilities = listOf("synchronize", "inner-focus"),
            gender = "75% M, 25% F",
            weaknesses = listOf("bug", "ghost", "dark"),
            evolutions = listOf("abra", "kadabra", "alakazam"),
            stats = listOf(
                PokemonStat("hp", 55), PokemonStat("attack", 50),
                PokemonStat("defense", 45), PokemonStat("special-attack", 135),
                PokemonStat("special-defense", 95), PokemonStat("speed", 120)
            ),
            description = "Seu cérebro nunca para de crescer, dando-lhe um QI superior a 5000."
        ),
        Pokemon(
            id = 66,
            name = "machop",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/66.png",
            types = listOf("fighting"),
            height = 0.8,
            weight = 19.5,
            abilities = listOf("guts", "no-guard"),
            gender = "75% M, 25% F",
            weaknesses = listOf("flying", "psychic", "fairy"),
            evolutions = listOf("machop", "machoke", "machamp"),
            stats = listOf(
                PokemonStat("hp", 70), PokemonStat("attack", 80),
                PokemonStat("defense", 50), PokemonStat("special-attack", 35),
                PokemonStat("special-defense", 35), PokemonStat("speed", 35)
            ),
            description = "Treina constantemente carregando pedras para fortalecer seus músculos."
        ),
        Pokemon(
            id = 67,
            name = "machoke",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/67.png",
            types = listOf("fighting"),
            height = 1.5,
            weight = 70.5,
            abilities = listOf("guts", "no-guard"),
            gender = "75% M, 25% F",
            weaknesses = listOf("flying", "psychic", "fairy"),
            evolutions = listOf("machop", "machoke", "machamp"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 100),
                PokemonStat("defense", 70), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 60), PokemonStat("speed", 45)
            ),
            description = "Usa um cinturão especial para conter sua força transbordante."
        ),
        Pokemon(
            id = 68,
            name = "machamp",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/68.png",
            types = listOf("fighting"),
            height = 1.6,
            weight = 130.0,
            abilities = listOf("guts", "no-guard"),
            gender = "75% M, 25% F",
            weaknesses = listOf("flying", "psychic", "fairy"),
            evolutions = listOf("machop", "machoke", "machamp"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 130),
                PokemonStat("defense", 80), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 85), PokemonStat("speed", 55)
            ),
            description = "Seus quatro braços permitem disparar socos de múltiplos ângulos."
        ),
        Pokemon(
            id = 69,
            name = "bellsprout",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/69.png",
            types = listOf("grass", "poison"),
            height = 0.7,
            weight = 4.0,
            abilities = listOf("chlorophyll", "gluttony"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "ice", "psychic"),
            evolutions = listOf("bellsprout", "weepinbell", "victreebel"),
            stats = listOf(
                PokemonStat("hp", 50), PokemonStat("attack", 75),
                PokemonStat("defense", 35), PokemonStat("special-attack", 70),
                PokemonStat("special-defense", 30), PokemonStat("speed", 40)
            ),
            description = "Enraíza seus pés para absorver nutrientes, mas é ágil o suficiente para caçar insetos."
        ),
        Pokemon(
            id = 70,
            name = "weepinbell",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/70.png",
            types = listOf("grass", "poison"),
            height = 1.0,
            weight = 6.4,
            abilities = listOf("chlorophyll", "gluttony"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "ice", "psychic"),
            evolutions = listOf("bellsprout", "weepinbell", "victreebel"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 90),
                PokemonStat("defense", 50), PokemonStat("special-attack", 85),
                PokemonStat("special-defense", 45), PokemonStat("speed", 55)
            ),
            description = "Usa seu gancho traseiro para se pendurar em galhos e surpreender presas."
        ),
        Pokemon(
            id = 71,
            name = "victreebel",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/71.png",
            types = listOf("grass", "poison"),
            height = 1.7,
            weight = 15.5,
            abilities = listOf("chlorophyll", "gluttony"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "ice", "psychic"),
            evolutions = listOf("bellsprout", "weepinbell", "victreebel"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 105),
                PokemonStat("defense", 65), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 70), PokemonStat("speed", 70)
            ),
            description = "Atrai presas com um aroma doce e as dissolve com ácido vegetal."
        ),
        Pokemon(
            id = 72,
            name = "tentacool",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/72.png",
            types = listOf("water", "poison"),
            height = 0.9,
            weight = 45.5,
            abilities = listOf("clear-body", "liquid-ooze"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ground", "electric", "psychic"),
            evolutions = listOf("tentacool", "tentacruel"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 40),
                PokemonStat("defense", 35), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 100), PokemonStat("speed", 70)
            ),
            description = "Composto majoritariamente de água, vagando pelo mar usando tentáculos venenosos."
        ),
        Pokemon(
            id = 73,
            name = "tentacruel",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/73.png",
            types = listOf("water", "poison"),
            height = 1.6,
            weight = 55.0,
            abilities = listOf("clear-body", "liquid-ooze"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ground", "electric", "psychic"),
            evolutions = listOf("tentacool", "tentacruel"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 70),
                PokemonStat("defense", 65), PokemonStat("special-attack", 80),
                PokemonStat("special-defense", 120), PokemonStat("speed", 100)
            ),
            description = "Possui 80 tentáculos e é conhecido como o gângster do mar."
        ),
        Pokemon(
            id = 74,
            name = "geodude",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/74.png",
            types = listOf("rock", "ground"),
            height = 0.4,
            weight = 20.0,
            abilities = listOf("rock-head", "sturdy"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice", "fighting", "ground", "steel"),
            evolutions = listOf("geodude", "graveler", "golem"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 80),
                PokemonStat("defense", 100), PokemonStat("special-attack", 30),
                PokemonStat("special-defense", 30), PokemonStat("speed", 20)
            ),
            description = "Comumente confundido com pedras em trilhas montanhosas."
        ),
        Pokemon(
            id = 75,
            name = "graveler",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/75.png",
            types = listOf("rock", "ground"),
            height = 1.0,
            weight = 105.0,
            abilities = listOf("rock-head", "sturdy"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice", "fighting", "ground", "steel"),
            evolutions = listOf("geodude", "graveler", "golem"),
            stats = listOf(
                PokemonStat("hp", 55), PokemonStat("attack", 95),
                PokemonStat("defense", 115), PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 45), PokemonStat("speed", 35)
            ),
            description = "Rola morro abaixo para se locomover, atropelando o que estiver na frente."
        ),
        Pokemon(
            id = 76,
            name = "golem",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/76.png",
            types = listOf("rock", "ground"),
            height = 1.4,
            weight = 300.0,
            abilities = listOf("rock-head", "sturdy"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice", "fighting", "ground", "steel"),
            evolutions = listOf("geodude", "graveler", "golem"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 120),
                PokemonStat("defense", 130), PokemonStat("special-attack", 55),
                PokemonStat("special-defense", 65), PokemonStat("speed", 45)
            ),
            description = "Tão resistente que nem dinamite causa arranhões em sua casca rochosa."
        ),
        Pokemon(
            id = 77,
            name = "ponyta",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/77.png",
            types = listOf("fire"),
            height = 1.0,
            weight = 30.0,
            abilities = listOf("run-away", "flash-fire"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "ground", "rock"),
            evolutions = listOf("ponyta", "rapidash"),
            stats = listOf(
                PokemonStat("hp", 50), PokemonStat("attack", 85),
                PokemonStat("defense", 55), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 65), PokemonStat("speed", 90)
            ),
            description = "Suas patas são capazes de saltar sobre prédios altos."
        ),
        Pokemon(
            id = 78,
            name = "rapidash",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/78.png",
            types = listOf("fire"),
            height = 1.7,
            weight = 95.0,
            abilities = listOf("run-away", "flash-fire"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "ground", "rock"),
            evolutions = listOf("ponyta", "rapidash"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 100),
                PokemonStat("defense", 70), PokemonStat("special-attack", 80),
                PokemonStat("special-defense", 80), PokemonStat("speed", 105)
            ),
            description = "Galopa a 240 km/h com sua crina flamejante ao vento."
        ),
        Pokemon(
            id = 79,
            name = "slowpoke",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/79.png",
            types = listOf("water", "psychic"),
            height = 1.2,
            weight = 36.0,
            abilities = listOf("oblivious", "own-tempo"),
            gender = "50% M, 50% F",
            weaknesses = listOf("bug", "ghost", "dark", "electric", "grass"),
            evolutions = listOf("slowpoke", "slowbro"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 65),
                PokemonStat("defense", 65), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 40), PokemonStat("speed", 15)
            ),
            description = "Lento em tudo o que faz. Demora para sentir dor até quando mordem sua cauda."
        ),
        Pokemon(
            id = 80,
            name = "slowbro",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/80.png",
            types = listOf("water", "psychic"),
            height = 1.6,
            weight = 78.5,
            abilities = listOf("oblivious", "own-tempo"),
            gender = "50% M, 50% F",
            weaknesses = listOf("bug", "ghost", "dark", "electric", "grass"),
            evolutions = listOf("slowpoke", "slowbro"),
            stats = listOf(
                PokemonStat("hp", 95), PokemonStat("attack", 75),
                PokemonStat("defense", 110), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 80), PokemonStat("speed", 30)
            ),
            description = "Evoluiu após um Shellder morder sua cauda."
        ),
        Pokemon(
            id = 81,
            name = "magnemite",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/81.png",
            types = listOf("electric", "steel"),
            height = 0.3,
            weight = 6.0,
            abilities = listOf("magnet-pull", "sturdy"),
            gender = "genderless",
            weaknesses = listOf("ground", "fighting", "fire"),
            evolutions = listOf("magnemite", "magneton"),
            stats = listOf(
                PokemonStat("hp", 25), PokemonStat("attack", 35),
                PokemonStat("defense", 70), PokemonStat("special-attack", 95),
                PokemonStat("special-defense", 55), PokemonStat("speed", 45)
            ),
            description = "Flutua usando magnetismo e é atraído por ondas eletromagnéticas."
        ),
        Pokemon(
            id = 82,
            name = "magneton",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/82.png",
            types = listOf("electric", "steel"),
            height = 1.0,
            weight = 60.0,
            abilities = listOf("magnet-pull", "sturdy"),
            gender = "genderless",
            weaknesses = listOf("ground", "fighting", "fire"),
            evolutions = listOf("magnemite", "magneton"),
            stats = listOf(
                PokemonStat("hp", 50), PokemonStat("attack", 60),
                PokemonStat("defense", 95), PokemonStat("special-attack", 120),
                PokemonStat("special-defense", 70), PokemonStat("speed", 70)
            ),
            description = "Três Magnemites unidos por uma força magnética intensa."
        ),
        Pokemon(
            id = 83,
            name = "farfetchd",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/83.png",
            types = listOf("normal", "flying"),
            height = 0.8,
            weight = 15.0,
            abilities = listOf("keen-eye", "inner-focus"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "rock", "ice"),
            evolutions = listOf("farfetchd"),
            stats = listOf(
                PokemonStat("hp", 52), PokemonStat("attack", 90),
                PokemonStat("defense", 55), PokemonStat("special-attack", 58),
                PokemonStat("special-defense", 62), PokemonStat("speed", 60)
            ),
            description = "Defende seu alho-poró ferozmente, usando-o como uma espada."
        ),
        Pokemon(
            id = 84,
            name = "doduo",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/84.png",
            types = listOf("normal", "flying"),
            height = 1.4,
            weight = 39.2,
            abilities = listOf("run-away", "early-bird"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "rock", "ice"),
            evolutions = listOf("doduo", "dodrio"),
            stats = listOf(
                PokemonStat("hp", 35), PokemonStat("attack", 85),
                PokemonStat("defense", 45), PokemonStat("special-attack", 35),
                PokemonStat("special-defense", 35), PokemonStat("speed", 75)
            ),
            description = "Suas duas cabeças estão interligadas telepaticamente."
        ),
        Pokemon(
            id = 85,
            name = "dodrio",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/85.png",
            types = listOf("normal", "flying"),
            height = 1.8,
            weight = 85.2,
            abilities = listOf("run-away", "early-bird"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "rock", "ice"),
            evolutions = listOf("doduo", "dodrio"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 110),
                PokemonStat("defense", 70), PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 60), PokemonStat("speed", 110)
            ),
            description = "Três cabeças representam alegria, tristeza e raiva."
        ),
        Pokemon(
            id = 86,
            name = "seel",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/86.png",
            types = listOf("water"),
            height = 1.1,
            weight = 90.0,
            abilities = listOf("thick-fat", "hydration"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("seel", "dewgong"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 45),
                PokemonStat("defense", 55), PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 70), PokemonStat("speed", 45)
            ),
            description = "Vive em icebergs e usa o chifre para furar o gelo."
        ),
        Pokemon(
            id = 87,
            name = "dewgong",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/87.png",
            types = listOf("water", "ice"),
            height = 1.7,
            weight = 120.0,
            abilities = listOf("thick-fat", "hydration"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass", "fighting", "rock"),
            evolutions = listOf("seel", "dewgong"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 70),
                PokemonStat("defense", 80), PokemonStat("special-attack", 70),
                PokemonStat("special-defense", 95), PokemonStat("speed", 70)
            ),
            description = "Prefere descansar em águas frias, onde armazena energia térmica."
        ),
        Pokemon(
            id = 88,
            name = "grimer",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/88.png",
            types = listOf("poison"),
            height = 0.9,
            weight = 30.0,
            abilities = listOf("stench", "sticky-hold"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ground", "psychic"),
            evolutions = listOf("grimer", "muk"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 80),
                PokemonStat("defense", 50), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 50), PokemonStat("speed", 25)
            ),
            description = "Nascido do lodo poluído dos esgotos urbanos."
        ),
        Pokemon(
            id = 89,
            name = "muk",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/89.png",
            types = listOf("poison"),
            height = 1.2,
            weight = 30.0,
            abilities = listOf("stench", "sticky-hold"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ground", "psychic"),
            evolutions = listOf("grimer", "muk"),
            stats = listOf(
                PokemonStat("hp", 105), PokemonStat("attack", 105),
                PokemonStat("defense", 75), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 100), PokemonStat("speed", 50)
            ),
            description = "Suas toxinas contaminam o solo por onde passa."
        ),
        Pokemon(
            id = 90,
            name = "shellder",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/90.png",
            types = listOf("water"),
            height = 0.3,
            weight = 4.0,
            abilities = listOf("shell-armor", "skill-link"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("shellder", "cloyster"),
            stats = listOf(
                PokemonStat("hp", 30), PokemonStat("attack", 65),
                PokemonStat("defense", 100), PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 25), PokemonStat("speed", 40)
            ),
            description = "Nada rapidamente abrindo e fechando seu casco resistente."
        ),
        Pokemon(
            id = 91,
            name = "cloyster",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/91.png",
            types = listOf("water", "ice"),
            height = 1.5,
            weight = 132.5,
            abilities = listOf("shell-armor", "skill-link"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass", "fighting", "rock"),
            evolutions = listOf("shellder", "cloyster"),
            stats = listOf(
                PokemonStat("hp", 50), PokemonStat("attack", 95),
                PokemonStat("defense", 180), PokemonStat("special-attack", 85),
                PokemonStat("special-defense", 45), PokemonStat("speed", 70)
            ),
            description = "Sua concha é tão dura que nem uma bomba consegue destruí-la."
        ),
        Pokemon(
            id = 92,
            name = "gastly",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/92.png",
            types = listOf("ghost", "poison"),
            height = 1.3,
            weight = 0.1,
            abilities = listOf("levitate"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ghost", "dark", "ground", "psychic"),
            evolutions = listOf("gastly", "haunter", "gengar"),
            stats = listOf(
                PokemonStat("hp", 30), PokemonStat("attack", 35),
                PokemonStat("defense", 30), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 35), PokemonStat("speed", 80)
            ),
            description = "Um ser gasoso que pode envolver e asfixiar presas de qualquer tamanho."
        ),
        Pokemon(
            id = 93,
            name = "haunter",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/93.png",
            types = listOf("ghost", "poison"),
            height = 1.6,
            weight = 0.1,
            abilities = listOf("levitate"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ghost", "dark", "ground", "psychic"),
            evolutions = listOf("gastly", "haunter", "gengar"),
            stats = listOf(
                PokemonStat("hp", 45), PokemonStat("attack", 50),
                PokemonStat("defense", 45), PokemonStat("special-attack", 115),
                PokemonStat("special-defense", 55), PokemonStat("speed", 95)
            ),
            description = "Gosta de lamber as pessoas para roubar sua energia vital."
        ),
        Pokemon(
            id = 94,
            name = "gengar",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/94.png",
            types = listOf("ghost", "poison"),
            height = 1.5,
            weight = 40.5,
            abilities = listOf("cursed-body"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ghost", "dark", "ground", "psychic"),
            evolutions = listOf("gastly", "haunter", "gengar"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 65),
                PokemonStat("defense", 60), PokemonStat("special-attack", 130),
                PokemonStat("special-defense", 75), PokemonStat("speed", 110)
            ),
            description = "Esconde-se nas sombras e sente prazer em assustar viajantes."
        ),
        Pokemon(
            id = 95,
            name = "onix",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/95.png",
            types = listOf("rock", "ground"),
            height = 8.8,
            weight = 210.0,
            abilities = listOf("rock-head", "sturdy"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice", "fighting", "ground", "steel"),
            evolutions = listOf("onix"),
            stats = listOf(
                PokemonStat("hp", 35), PokemonStat("attack", 45),
                PokemonStat("defense", 160), PokemonStat("special-attack", 30),
                PokemonStat("special-defense", 45), PokemonStat("speed", 70)
            ),
            description = "Cava túneis no subsolo a altas velocidades em busca de comida."
        ),
        Pokemon(
            id = 96,
            name = "drowzee",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/96.png",
            types = listOf("psychic"),
            height = 1.0,
            weight = 32.4,
            abilities = listOf("insomnia", "forewarn"),
            gender = "50% M, 50% F",
            weaknesses = listOf("bug", "ghost", "dark"),
            evolutions = listOf("drowzee", "hypno"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 48),
                PokemonStat("defense", 45), PokemonStat("special-attack", 43),
                PokemonStat("special-defense", 90), PokemonStat("speed", 42)
            ),
            description = "Pode pressentir o que as pessoas estão sonhando."
        ),
        Pokemon(
            id = 97,
            name = "hypno",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/97.png",
            types = listOf("psychic"),
            height = 1.6,
            weight = 75.6,
            abilities = listOf("insomnia", "forewarn"),
            gender = "50% M, 50% F",
            weaknesses = listOf("bug", "ghost", "dark"),
            evolutions = listOf("drowzee", "hypno"),
            stats = listOf(
                PokemonStat("hp", 85), PokemonStat("attack", 73),
                PokemonStat("defense", 70), PokemonStat("special-attack", 73),
                PokemonStat("special-defense", 115), PokemonStat("speed", 67)
            ),
            description = "Evite olhar para seu pêndulo ou será hipnotizado instantaneamente."
        ),
        Pokemon(
            id = 98,
            name = "krabby",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/98.png",
            types = listOf("water"),
            height = 0.4,
            weight = 6.5,
            abilities = listOf("hyper-cutter", "shell-armor"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("krabby", "kingler"),
            stats = listOf(
                PokemonStat("hp", 30), PokemonStat("attack", 105),
                PokemonStat("defense", 90), PokemonStat("special-attack", 25),
                PokemonStat("special-defense", 25), PokemonStat("speed", 50)
            ),
            description = "Seu bico pode quebrar conchas duras com facilidade."
        ),
        Pokemon(
            id = 99,
            name = "kingler",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/99.png",
            types = listOf("water"),
            height = 1.3,
            weight = 60.0,
            abilities = listOf("hyper-cutter", "shell-armor"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("krabby", "kingler"),
            stats = listOf(
                PokemonStat("hp", 55), PokemonStat("attack", 130),
                PokemonStat("defense", 115), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 50), PokemonStat("speed", 75)
            ),
            description = "Uma de suas garras cresceu enormemente, sendo uma arma poderosa."
        ),
        Pokemon(
            id = 100,
            name = "voltorb",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/100.png",
            types = listOf("electric"),
            height = 0.5,
            weight = 10.4,
            abilities = listOf("soundproof", "static"),
            gender = "genderless",
            weaknesses = listOf("ground"),
            evolutions = listOf("voltorb", "electrode"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 30),
                PokemonStat("defense", 50), PokemonStat("special-attack", 55),
                PokemonStat("special-defense", 55), PokemonStat("speed", 100)
            ),
            description = "Muitas vezes confundido com uma Pokébola, explode ao menor toque."
        ),
        Pokemon(
            id = 101,
            name = "electrode",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/101.png",
            types = listOf("electric"),
            height = 1.2,
            weight = 66.6,
            abilities = listOf("soundproof", "static"),
            gender = "genderless",
            weaknesses = listOf("ground"),
            evolutions = listOf("voltorb", "electrode"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 50),
                PokemonStat("defense", 70), PokemonStat("special-attack", 80),
                PokemonStat("special-defense", 80), PokemonStat("speed", 150)
            ),
            description = "Acumula tanta eletricidade que explode sob a menor estimulação."
        ),
        Pokemon(
            id = 102,
            name = "exeggcute",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/102.png",
            types = listOf("grass", "psychic"),
            height = 0.4,
            weight = 2.5,
            abilities = listOf("chlorophyll", "harvest"),
            gender = "50% M, 50% F",
            weaknesses = listOf("bug", "ghost", "dark", "fire", "flying", "ice", "poison"),
            evolutions = listOf("exeggcute", "exeggutor"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 40),
                PokemonStat("defense", 80), PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 45), PokemonStat("speed", 40)
            ),
            description = "Seis sementes que se mantêm unidas por telepatia."
        ),
        Pokemon(
            id = 103,
            name = "exeggutor",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/103.png",
            types = listOf("grass", "psychic"),
            height = 2.0,
            weight = 120.0,
            abilities = listOf("chlorophyll", "harvest"),
            gender = "50% M, 50% F",
            weaknesses = listOf("bug", "ghost", "dark", "fire", "flying", "ice", "poison"),
            evolutions = listOf("exeggcute", "exeggutor"),
            stats = listOf(
                PokemonStat("hp", 95), PokemonStat("attack", 95),
                PokemonStat("defense", 85), PokemonStat("special-attack", 125),
                PokemonStat("special-defense", 75), PokemonStat("speed", 55)
            ),
            description = "Diz-se que cada uma de suas cabeças pensa de forma independente."
        ),
        Pokemon(
            id = 104,
            name = "cubone",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/104.png",
            types = listOf("ground"),
            height = 0.4,
            weight = 6.5,
            abilities = listOf("rock-head", "lightning-rod"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice"),
            evolutions = listOf("cubone", "marowak"),
            stats = listOf(
                PokemonStat("hp", 50), PokemonStat("attack", 50),
                PokemonStat("defense", 95), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 50), PokemonStat("speed", 35)
            ),
            description = "Chora pela mãe que perdeu e usa seu crânio como capacete."
        ),
        Pokemon(
            id = 105,
            name = "marowak",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/105.png",
            types = listOf("ground"),
            height = 1.0,
            weight = 45.0,
            abilities = listOf("rock-head", "lightning-rod"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice"),
            evolutions = listOf("cubone", "marowak"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 80),
                PokemonStat("defense", 110), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 80), PokemonStat("speed", 45)
            ),
            description = "Tornou-se feroz e usa um osso como arma de combate."
        ),
        Pokemon(
            id = 106,
            name = "hitmonlee",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/106.png",
            types = listOf("fighting"),
            height = 1.5,
            weight = 49.8,
            abilities = listOf("limber", "reckless"),
            gender = "100% M, 0% F",
            weaknesses = listOf("flying", "psychic", "fairy"),
            evolutions = listOf("hitmonlee"),
            stats = listOf(
                PokemonStat("hp", 50), PokemonStat("attack", 120),
                PokemonStat("defense", 53), PokemonStat("special-attack", 35),
                PokemonStat("special-defense", 110), PokemonStat("speed", 87)
            ),
            description = "Suas pernas podem esticar-se para desferir chutes devastadores."
        ),
        Pokemon(
            id = 107,
            name = "hitmonchan",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/107.png",
            types = listOf("fighting"),
            height = 1.4,
            weight = 50.2,
            abilities = listOf("keen-eye", "iron-fist"),
            gender = "100% M, 0% F",
            weaknesses = listOf("flying", "psychic", "fairy"),
            evolutions = listOf("hitmonchan"),
            stats = listOf(
                PokemonStat("hp", 50), PokemonStat("attack", 105),
                PokemonStat("defense", 79), PokemonStat("special-attack", 35),
                PokemonStat("special-defense", 110), PokemonStat("speed", 76)
            ),
            description = "Desfere socos tão rápidos que são invisíveis ao olho humano."
        ),
        Pokemon(
            id = 108,
            name = "lickitung",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/108.png",
            types = listOf("normal"),
            height = 1.2,
            weight = 65.5,
            abilities = listOf("own-tempo", "oblivious"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fighting"),
            evolutions = listOf("lickitung"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 55),
                PokemonStat("defense", 75), PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 75), PokemonStat("speed", 30)
            ),
            description = "Usa sua língua enorme para paralisar e capturar presas."
        ),
        Pokemon(
            id = 109,
            name = "koffing",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/109.png",
            types = listOf("poison"),
            height = 0.6,
            weight = 1.0,
            abilities = listOf("levitate", "neutralizing-gas"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ground", "psychic"),
            evolutions = listOf("koffing", "weezing"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 65),
                PokemonStat("defense", 95), PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 45), PokemonStat("speed", 35)
            ),
            description = "Seu corpo está cheio de gases tóxicos e explosivos."
        ),
        Pokemon(
            id = 110,
            name = "weezing",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/110.png",
            types = listOf("poison"),
            height = 1.2,
            weight = 9.5,
            abilities = listOf("levitate", "neutralizing-gas"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ground", "psychic"),
            evolutions = listOf("koffing", "weezing"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 90),
                PokemonStat("defense", 120), PokemonStat("special-attack", 85),
                PokemonStat("special-defense", 70), PokemonStat("speed", 60)
            ),
            description = "Vive em locais poluídos e adora gases de lixo."
        ),
        Pokemon(
            id = 111,
            name = "rhyhorn",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/111.png",
            types = listOf("ground", "rock"),
            height = 1.0,
            weight = 115.0,
            abilities = listOf("lightning-rod", "rock-head"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice", "fighting", "ground", "steel"),
            evolutions = listOf("rhyhorn", "rhydon"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 85),
                PokemonStat("defense", 95), PokemonStat("special-attack", 30),
                PokemonStat("special-defense", 30), PokemonStat("speed", 25)
            ),
            description = "Sua carga destrutiva pode derrubar até edifícios."
        ),
        Pokemon(
            id = 112,
            name = "rhydon",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/112.png",
            types = listOf("ground", "rock"),
            height = 1.9,
            weight = 120.0,
            abilities = listOf("lightning-rod", "rock-head"),
            gender = "50% M, 50% F",
            weaknesses = listOf("water", "grass", "ice", "fighting", "ground", "steel"),
            evolutions = listOf("rhyhorn", "rhydon"),
            stats = listOf(
                PokemonStat("hp", 105), PokemonStat("attack", 130),
                PokemonStat("defense", 120), PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 45), PokemonStat("speed", 40)
            ),
            description = "Sua pele é tão grossa que pode nadar em lava."
        ),
        Pokemon(
            id = 113,
            name = "chansey",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/113.png",
            types = listOf("normal"),
            height = 1.1,
            weight = 34.6,
            abilities = listOf("natural-cure", "serene-grace"),
            gender = "0% M, 100% F",
            weaknesses = listOf("fighting"),
            evolutions = listOf("chansey"),
            stats = listOf(
                PokemonStat("hp", 250), PokemonStat("attack", 5),
                PokemonStat("defense", 5), PokemonStat("special-attack", 35),
                PokemonStat("special-defense", 105), PokemonStat("speed", 50)
            ),
            description = "Um Pokémon bondoso que partilha seus ovos nutritivos com os feridos."
        ),
        Pokemon(
            id = 114,
            name = "tangela",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/114.png",
            types = listOf("grass"),
            height = 1.0,
            weight = 35.0,
            abilities = listOf("chlorophyll", "leaf-guard"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "ice", "poison", "bug"),
            evolutions = listOf("tangela"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 55),
                PokemonStat("defense", 115), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 40), PokemonStat("speed", 60)
            ),
            description = "O seu corpo está envolto em vinhas que nunca param de crescer."
        ),
        Pokemon(
            id = 115,
            name = "kangaskhan",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/115.png",
            types = listOf("normal"),
            height = 2.2,
            weight = 80.0,
            abilities = listOf("early-bird", "scrappy"),
            gender = "0% M, 100% F",
            weaknesses = listOf("fighting"),
            evolutions = listOf("kangaskhan"),
            stats = listOf(
                PokemonStat("hp", 105), PokemonStat("attack", 95),
                PokemonStat("defense", 80), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 80), PokemonStat("speed", 90)
            ),
            description = "Protege o seu filhote na bolsa da barriga com extrema ferocidade."
        ),
        Pokemon(
            id = 116,
            name = "horsea",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/116.png",
            types = listOf("water"),
            height = 0.4,
            weight = 8.0,
            abilities = listOf("swift-swim", "sniper"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("horsea", "seadra"),
            stats = listOf(
                PokemonStat("hp", 30), PokemonStat("attack", 40),
                PokemonStat("defense", 70), PokemonStat("special-attack", 70),
                PokemonStat("special-defense", 25), PokemonStat("speed", 60)
            ),
            description = "Cospe tinta para confundir inimigos e fugir."
        ),
        Pokemon(
            id = 117,
            name = "seadra",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/117.png",
            types = listOf("water"),
            height = 1.2,
            weight = 25.0,
            abilities = listOf("poison-point", "sniper"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("horsea", "seadra"),
            stats = listOf(
                PokemonStat("hp", 55), PokemonStat("attack", 65),
                PokemonStat("defense", 95), PokemonStat("special-attack", 95),
                PokemonStat("special-defense", 45), PokemonStat("speed", 85)
            ),
            description = "Seus espinhos são venenosos e podem causar paralisia."
        ),
        Pokemon(
            id = 118,
            name = "goldeen",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/118.png",
            types = listOf("water"),
            height = 0.6,
            weight = 15.0,
            abilities = listOf("swift-swim", "water-veil"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("goldeen", "seaking"),
            stats = listOf(
                PokemonStat("hp", 45), PokemonStat("attack", 67),
                PokemonStat("defense", 60), PokemonStat("special-attack", 35),
                PokemonStat("special-defense", 50), PokemonStat("speed", 63)
            ),
            description = "Nada com elegância, mas ataca ferozmente com o seu chifre."
        ),
        Pokemon(
            id = 119,
            name = "seaking",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/119.png",
            types = listOf("water"),
            height = 1.3,
            weight = 39.0,
            abilities = listOf("swift-swim", "water-veil"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("goldeen", "seaking"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 92),
                PokemonStat("defense", 65), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 80), PokemonStat("speed", 68)
            ),
            description = "Usa o seu chifre potente para perfurar rochas e fazer ninhos."
        ),
        Pokemon(
            id = 120,
            name = "staryu",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/120.png",
            types = listOf("water"),
            height = 0.8,
            weight = 34.5,
            abilities = listOf("illuminate", "natural-cure"),
            gender = "genderless",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("staryu", "starmie"),
            stats = listOf(
                PokemonStat("hp", 30), PokemonStat("attack", 45),
                PokemonStat("defense", 55), PokemonStat("special-attack", 70),
                PokemonStat("special-defense", 55), PokemonStat("speed", 85)
            ),
            description = "O núcleo no seu centro brilha intensamente à noite."
        ),
        Pokemon(
            id = 121,
            name = "starmie",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/121.png",
            types = listOf("water", "psychic"),
            height = 1.1,
            weight = 80.0,
            abilities = listOf("illuminate", "natural-cure"),
            gender = "genderless",
            weaknesses = listOf("bug", "ghost", "dark", "electric", "grass"),
            evolutions = listOf("staryu", "starmie"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 75),
                PokemonStat("defense", 85), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 85), PokemonStat("speed", 115)
            ),
            description = "O seu núcleo brilha com as cores do arco-íris."
        ),
        Pokemon(
            id = 122,
            name = "mr-mime",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/122.png",
            types = listOf("psychic", "fairy"),
            height = 1.3,
            weight = 54.5,
            abilities = listOf("soundproof", "filter"),
            gender = "50% M, 50% F",
            weaknesses = listOf("poison", "ghost", "steel"),
            evolutions = listOf("mr-mime"),
            stats = listOf(
                PokemonStat("hp", 40), PokemonStat("attack", 45),
                PokemonStat("defense", 65), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 120), PokemonStat("speed", 90)
            ),
            description = "Cria paredes invisíveis usando os seus dedos."
        ),
        Pokemon(
            id = 123,
            name = "scyther",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/123.png",
            types = listOf("bug", "flying"),
            height = 1.5,
            weight = 56.0,
            abilities = listOf("swarm", "technician"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "rock", "electric", "ice"),
            evolutions = listOf("scyther"),
            stats = listOf(
                PokemonStat("hp", 70), PokemonStat("attack", 110),
                PokemonStat("defense", 80), PokemonStat("special-attack", 55),
                PokemonStat("special-defense", 80), PokemonStat("speed", 105)
            ),
            description = "Suas garras em forma de foice podem cortar troncos grossos."
        ),
        Pokemon(
            id = 124,
            name = "jynx",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/124.png",
            types = listOf("ice", "psychic"),
            height = 1.4,
            weight = 40.6,
            abilities = listOf("oblivious", "forewarn"),
            gender = "0% M, 100% F",
            weaknesses = listOf("fire", "bug", "rock", "ghost", "steel", "dark"),
            evolutions = listOf("jynx"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 50),
                PokemonStat("defense", 35), PokemonStat("special-attack", 115),
                PokemonStat("special-defense", 95), PokemonStat("speed", 95)
            ),
            description = "Dança de forma sedutora para colocar inimigos em transe."
        ),
        Pokemon(
            id = 125,
            name = "electabuzz",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/125.png",
            types = listOf("electric"),
            height = 1.1,
            weight = 30.0,
            abilities = listOf("static", "vital-spirit"),
            gender = "75% M, 25% F",
            weaknesses = listOf("ground"),
            evolutions = listOf("electabuzz", "electivire"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 83),
                PokemonStat("defense", 57), PokemonStat("special-attack", 95),
                PokemonStat("special-defense", 85), PokemonStat("speed", 105)
            ),
            description = "Alimenta-se de eletricidade e causa apagões em cidades."
        ),
        Pokemon(
            id = 126,
            name = "magmar",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/126.png",
            types = listOf("fire"),
            height = 1.3,
            weight = 44.5,
            abilities = listOf("flame-body", "vital-spirit"),
            gender = "75% M, 25% F",
            weaknesses = listOf("water", "ground", "rock"),
            evolutions = listOf("magmar"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 95),
                PokemonStat("defense", 57), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 85), PokemonStat("speed", 93)
            ),
            description = "O seu corpo queima a uma temperatura altíssima."
        ),
        Pokemon(
            id = 127,
            name = "pinsir",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/127.png",
            types = listOf("bug"),
            height = 1.5,
            weight = 55.0,
            abilities = listOf("hyper-cutter", "mold-breaker"),
            gender = "50% M, 50% F",
            weaknesses = listOf("fire", "flying", "rock"),
            evolutions = listOf("pinsir"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 125),
                PokemonStat("defense", 100), PokemonStat("special-attack", 55),
                PokemonStat("special-defense", 70), PokemonStat("speed", 85)
            ),
            description = "Esmaga presas com os seus chifres poderosos."
        ),
        Pokemon(
            id = 128,
            name = "tauros",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/128.png",
            types = listOf("normal"),
            height = 1.4,
            weight = 88.4,
            abilities = listOf("intimidate", "anger-point"),
            gender = "100% M, 0% F",
            weaknesses = listOf("fighting"),
            evolutions = listOf("tauros"),
            stats = listOf(
                PokemonStat("hp", 75), PokemonStat("attack", 100),
                PokemonStat("defense", 95), PokemonStat("special-attack", 40),
                PokemonStat("special-defense", 70), PokemonStat("speed", 110)
            ),
            description = "Um Pokémon violento que ataca qualquer coisa que se mova."
        ),
        Pokemon(
            id = 129,
            name = "magikarp",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/129.png",
            types = listOf("water"),
            height = 0.9,
            weight = 10.0,
            abilities = listOf("swift-swim", "rattled"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("magikarp", "gyarados"),
            stats = listOf(
                PokemonStat("hp", 20), PokemonStat("attack", 10),
                PokemonStat("defense", 55), PokemonStat("special-attack", 15),
                PokemonStat("special-defense", 20), PokemonStat("speed", 80)
            ),
            description = "Famoso por ser o Pokémon mais fraco do mundo."
        ),
        Pokemon(
            id = 130,
            name = "gyarados",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/130.png",
            types = listOf("water", "flying"),
            height = 6.5,
            weight = 235.0,
            abilities = listOf("intimidate", "moxie"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "rock"),
            evolutions = listOf("magikarp", "gyarados"),
            stats = listOf(
                PokemonStat("hp", 95), PokemonStat("attack", 125),
                PokemonStat("defense", 79), PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 100), PokemonStat("speed", 81)
            ),
            description = "Pode destruir cidades inteiras num acesso de fúria."
        ),
        Pokemon(
            id = 131,
            name = "lapras",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/131.png",
            types = listOf("water", "ice"),
            height = 2.5,
            weight = 220.0,
            abilities = listOf("water-absorb", "shell-armor"),
            gender = "50% M, 50% F",
            weaknesses = listOf("electric", "grass", "fighting", "rock"),
            evolutions = listOf("lapras"),
            stats = listOf(
                PokemonStat("hp", 130), PokemonStat("attack", 85),
                PokemonStat("defense", 80), PokemonStat("special-attack", 85),
                PokemonStat("special-defense", 95), PokemonStat("speed", 60)
            ),
            description = "Um Pokémon dócil que gosta de transportar pessoas no dorso."
        ),
        Pokemon(
            id = 132,
            name = "ditto",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png",
            types = listOf("normal"),
            height = 0.3,
            weight = 4.0,
            abilities = listOf("limber", "imposter"),
            gender = "genderless",
            weaknesses = listOf("fighting"),
            evolutions = listOf("ditto"),
            stats = listOf(
                PokemonStat("hp", 48), PokemonStat("attack", 48),
                PokemonStat("defense", 48), PokemonStat("special-attack", 48),
                PokemonStat("special-defense", 48), PokemonStat("speed", 48)
            ),
            description = "Pode transformar-se em qualquer outro Pokémon."
        ),
        Pokemon(
            id = 133,
            name = "eevee",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/133.png",
            types = listOf("normal"),
            height = 0.3,
            weight = 6.5,
            abilities = listOf("run-away", "adaptability"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("fighting"),
            evolutions = listOf("eevee", "vaporeon", "jolteon", "flareon"),
            stats = listOf(
                PokemonStat("hp", 55), PokemonStat("attack", 55),
                PokemonStat("defense", 50), PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 65), PokemonStat("speed", 55)
            ),
            description = "Tem um código genético instável que lhe permite evoluir para várias formas."
        ),
        Pokemon(
            id = 134,
            name = "vaporeon",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/134.png",
            types = listOf("water"),
            height = 1.0,
            weight = 29.0,
            abilities = listOf("water-absorb", "hydration"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("electric", "grass"),
            evolutions = listOf("eevee", "vaporeon", "jolteon", "flareon"),
            stats = listOf(
                PokemonStat("hp", 130), PokemonStat("attack", 65),
                PokemonStat("defense", 60), PokemonStat("special-attack", 110),
                PokemonStat("special-defense", 95), PokemonStat("speed", 65)
            ),
            description = "A sua estrutura celular é semelhante à das moléculas de água."
        ),
        Pokemon(
            id = 135,
            name = "jolteon",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/135.png",
            types = listOf("electric"),
            height = 0.8,
            weight = 24.5,
            abilities = listOf("volt-absorb", "quick-feet"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("ground"),
            evolutions = listOf("eevee", "vaporeon", "jolteon", "flareon"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 65),
                PokemonStat("defense", 60), PokemonStat("special-attack", 110),
                PokemonStat("special-defense", 95), PokemonStat("speed", 130)
            ),
            description = "Acumula iões negativos no pelo para disparar choques elétricos."
        ),
        Pokemon(
            id = 136,
            name = "flareon",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/136.png",
            types = listOf("fire"),
            height = 0.9,
            weight = 25.0,
            abilities = listOf("flash-fire", "guts"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("water", "ground", "rock"),
            evolutions = listOf("eevee", "vaporeon", "jolteon", "flareon", "espeon", "umbreon", "leafeon", "glaceon", "sylveon"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 130),
                PokemonStat("defense", 60), PokemonStat("special-attack", 95),
                PokemonStat("special-defense", 110), PokemonStat("speed", 65)
            ),
            description = "Armazena calor no seu corpo e pode atingir temperaturas extremas."
        ),
        Pokemon(
            id = 137,
            name = "porygon",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/137.png",
            types = listOf("normal"),
            height = 0.8,
            weight = 36.5,
            abilities = listOf("trace", "download"),
            gender = "genderless",
            weaknesses = listOf("fighting"),
            evolutions = listOf("porygon"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 60),
                PokemonStat("defense", 70), PokemonStat("special-attack", 85),
                PokemonStat("special-defense", 75), PokemonStat("speed", 40)
            ),
            description = "O primeiro Pokémon artificial criado pela ciência."
        ),
        Pokemon(
            id = 138,
            name = "omanyte",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/138.png",
            types = listOf("rock", "water"),
            height = 0.4,
            weight = 7.5,
            abilities = listOf("swift-swim", "shell-armor"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("grass", "electric", "fighting", "ground"),
            evolutions = listOf("omanyte", "omastar"),
            stats = listOf(
                PokemonStat("hp", 35), PokemonStat("attack", 40),
                PokemonStat("defense", 100), PokemonStat("special-attack", 90),
                PokemonStat("special-defense", 55), PokemonStat("speed", 35)
            ),
            description = "Pokémon fóssil ressuscitado a partir de vestígios antigos."
        ),
        Pokemon(
            id = 139,
            name = "omastar",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/139.png",
            types = listOf("rock", "water"),
            height = 1.0,
            weight = 35.0,
            abilities = listOf("swift-swim", "shell-armor"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("grass", "electric", "fighting", "ground"),
            evolutions = listOf("omanyte", "omastar"),
            stats = listOf(
                PokemonStat("hp", 70), PokemonStat("attack", 60),
                PokemonStat("defense", 125), PokemonStat("special-attack", 115),
                PokemonStat("special-defense", 70), PokemonStat("speed", 55)
            ),
            description = "O peso da sua concha dificultava a sua sobrevivência e locomoção."
        ),
        Pokemon(
            id = 140,
            name = "kabuto",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/140.png",
            types = listOf("rock", "water"),
            height = 0.5,
            weight = 11.5,
            abilities = listOf("swift-swim", "battle-armor"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("grass", "electric", "fighting", "ground"),
            evolutions = listOf("kabuto", "kabutops"),
            stats = listOf(
                PokemonStat("hp", 30), PokemonStat("attack", 80),
                PokemonStat("defense", 90), PokemonStat("special-attack", 55),
                PokemonStat("special-defense", 45), PokemonStat("speed", 55)
            ),
            description = "Pokémon fóssil que usava a carapaça para se esconder no fundo do mar."
        ),
        Pokemon(
            id = 141,
            name = "kabutops",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/141.png",
            types = listOf("rock", "water"),
            height = 1.3,
            weight = 40.5,
            abilities = listOf("swift-swim", "battle-armor"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("grass", "electric", "fighting", "ground"),
            evolutions = listOf("kabuto", "kabutops"),
            stats = listOf(
                PokemonStat("hp", 60), PokemonStat("attack", 115),
                PokemonStat("defense", 105), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 70), PokemonStat("speed", 80)
            ),
            description = "Um predador marinho letal com garras afiadas."
        ),
        Pokemon(
            id = 142,
            name = "aerodactyl",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/142.png",
            types = listOf("rock", "flying"),
            height = 1.8,
            weight = 59.0,
            abilities = listOf("rock-head", "pressure"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("water", "electric", "ice", "rock", "steel"),
            evolutions = listOf("aerodactyl"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 105),
                PokemonStat("defense", 65), PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 75), PokemonStat("speed", 130)
            ),
            description = "O rei dos céus na era pré-histórica."
        ),
        Pokemon(
            id = 143,
            name = "snorlax",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/143.png",
            types = listOf("normal"),
            height = 2.1,
            weight = 460.0,
            abilities = listOf("immunity", "thick-fat"),
            gender = "87.5% M, 12.5% F",
            weaknesses = listOf("fighting"),
            evolutions = listOf("snorlax"),
            stats = listOf(
                PokemonStat("hp", 160), PokemonStat("attack", 110),
                PokemonStat("defense", 65), PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 110), PokemonStat("speed", 30)
            ),
            description = "Passa o dia todo a comer e a dormir."
        ),
        Pokemon(
            id = 144,
            name = "articuno",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/144.png",
            types = listOf("ice", "flying"),
            height = 1.7,
            weight = 55.4,
            abilities = listOf("pressure"),
            gender = "genderless",
            weaknesses = listOf("rock", "fire", "electric", "steel"),
            evolutions = listOf("articuno"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 85),
                PokemonStat("defense", 100), PokemonStat("special-attack", 95),
                PokemonStat("special-defense", 125), PokemonStat("speed", 85)
            ),
            description = "Uma das aves lendárias, diz-se que aparece aos perdidos em montanhas geladas."
        ),
        Pokemon(
            id = 145,
            name = "zapdos",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/145.png",
            types = listOf("electric", "flying"),
            height = 1.6,
            weight = 52.6,
            abilities = listOf("pressure"),
            gender = "genderless",
            weaknesses = listOf("ice", "rock"),
            evolutions = listOf("zapdos"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 90),
                PokemonStat("defense", 85), PokemonStat("special-attack", 125),
                PokemonStat("special-defense", 90), PokemonStat("speed", 100)
            ),
            description = "Diz-se que vive em nuvens de tempestade e ganha força ao ser atingido por raios."
        ),
        Pokemon(
            id = 146,
            name = "moltres",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/146.png",
            types = listOf("fire", "flying"),
            height = 2.0,
            weight = 60.0,
            abilities = listOf("pressure"),
            gender = "genderless",
            weaknesses = listOf("rock", "water", "electric"),
            evolutions = listOf("moltres"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 100),
                PokemonStat("defense", 90), PokemonStat("special-attack", 125),
                PokemonStat("special-defense", 85), PokemonStat("speed", 90)
            ),
            description = "A sua presença anuncia a chegada da primavera."
        ),
        Pokemon(
            id = 147,
            name = "dratini",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/147.png",
            types = listOf("dragon"),
            height = 1.8,
            weight = 3.3,
            abilities = listOf("shed-skin"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ice", "dragon", "fairy"),
            evolutions = listOf("dratini", "dragonair", "dragonite"),
            stats = listOf(
                PokemonStat("hp", 41), PokemonStat("attack", 64),
                PokemonStat("defense", 45), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 50), PokemonStat("speed", 50)
            ),
            description = "Pokémon raro que vive em águas calmas e profundas."
        ),
        Pokemon(
            id = 148,
            name = "dragonair",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/148.png",
            types = listOf("dragon"),
            height = 4.0,
            weight = 16.5,
            abilities = listOf("shed-skin"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ice", "dragon", "fairy"),
            evolutions = listOf("dratini", "dragonair", "dragonite"),
            stats = listOf(
                PokemonStat("hp", 61), PokemonStat("attack", 84),
                PokemonStat("defense", 65), PokemonStat("special-attack", 70),
                PokemonStat("special-defense", 70), PokemonStat("speed", 70)
            ),
            description = "Diz-se que altera o clima através da energia mística das suas esferas."
        ),
        Pokemon(
            id = 149,
            name = "dragonite",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/149.png",
            types = listOf("dragon", "flying"),
            height = 2.2,
            weight = 210.0,
            abilities = listOf("inner-focus"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ice", "rock", "dragon", "fairy"),
            evolutions = listOf("dratini", "dragonair", "dragonite"),
            stats = listOf(
                PokemonStat("hp", 91), PokemonStat("attack", 134),
                PokemonStat("defense", 95), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 100), PokemonStat("speed", 80)
            ),
            description = "Pokémon muito bondoso que salva marinheiros perdidos em tempestades."
        ),
        Pokemon(
            id = 150,
            name = "mewtwo",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png",
            types = listOf("psychic"),
            height = 2.0,
            weight = 122.0,
            abilities = listOf("pressure"),
            gender = "genderless",
            weaknesses = listOf("bug", "ghost", "dark"),
            evolutions = listOf("mewtwo"),
            stats = listOf(
                PokemonStat("hp", 106), PokemonStat("attack", 110),
                PokemonStat("defense", 90), PokemonStat("special-attack", 154),
                PokemonStat("special-defense", 90), PokemonStat("speed", 130)
            ),
            description = "Criado em laboratório, o seu poder psíquico é incomparável."
        ),
        Pokemon(
            id = 151,
            name = "mew",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/151.png",
            types = listOf("psychic"),
            height = 0.4,
            weight = 4.0,
            abilities = listOf("synchronize"),
            gender = "genderless",
            weaknesses = listOf("bug", "ghost", "dark"),
            evolutions = listOf("mew"),
            stats = listOf(
                PokemonStat("hp", 100), PokemonStat("attack", 100),
                PokemonStat("defense", 100), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 100), PokemonStat("speed", 100)
            ),
            description = "Diz-se que contém o código genético de todos os Pokémon."
        )
    )

    fun findById(id: Int): Pokemon? = pokedex.firstOrNull { it.id == id }
}