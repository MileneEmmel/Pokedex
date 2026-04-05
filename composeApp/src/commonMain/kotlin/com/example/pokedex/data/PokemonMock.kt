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
            description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon."
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
            description = "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs."
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
            description = "The plant blooms by absorbing solar energy. It flowers and becomes more colorful under sunlight."
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
            description = "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail."
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
            description = "When it swings its burning tail, it elevates the temperature to unbearably high levels."
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
            description = "Spits fire that is hot enough to melt boulders. Known to cause forest fires unintentionally."
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
            description = "After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth."
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
            description = "Often hides in water to elude hasty attackers. It can move quickly to avoid being spotted."
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
            description = "A brutal Pokémon with pressurized water jets on its shell. They are used for high speed tackles."
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
            description = "Its short feet are tipped with suction pads that enable it to tirelessly climb slopes and walls."
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
            description = "This Pokémon is vulnerable to attack while its shell is soft, exposing its weak and tender body."
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
            description = "In battle, it flaps its wings at high speed to release highly toxic dust into the air."
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
            description = "Often found in forests, eating leaves. It has a sharp venomous stinger on its head."
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
            description = "Almost incapable of moving, this Pokémon can only harden its shell to protect itself from predators."
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
            description = "Flies at high speed and attacks using its three venomous stingers on its forelegs and abdomen."
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
            description = "A common sight in forests and woods. It flaps its wings at ground level to kick up blinding sand."
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
            description = "Very protective of its sprawling territorial area, this Pokémon will fiercely peck at any intruder."
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
            description = "When hunting, it skims the surface of water at high speed to pick off unwary prey such as Magikarp."
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
            description = "Bites anything when it attacks. Small and very quick, it is a common sight in many places."
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
            description = "It uses its whiskers to maintain its balance. It apparently slows down if they are cut off."
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
            description = "Eats bugs in grassy areas. It has to flap its short wings very fast to stay airborne."
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
            description = "With its huge and magnificent wings, it can keep aloft without ever having to land for rest."
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
            description = "Moves silently and stealthily. Eats the eggs of birds, such as Pidgey and Spearow, whole."
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
            description = "It is rumored that the ferocious warning markings on its belly differ from area to area."
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
            description = "When several of these Pokémon gather, their electricity could build and cause lightning storms."
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
            description = "Its long tail serves as a ground to protect itself from its own high-voltage power."
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
            description = "Burrows deep underground in arid locations far from water. It only emerges to hunt for food."
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
            description = "Curls up into a spiny ball when threatened. It can roll while curled up to attack or escape."
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
            description = "Although small, its venomous barbs render this Pokémon dangerous. The female has smaller horns."
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
            description = "The female's horn develops slowly. Prefers physical attacks such as clawing and biting."
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
            description = "Its hard scales provide strong protection. It uses its hefty bulk to execute powerful moves."
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
            description = "Stiffens its ears to sense danger. The larger its horns, the more powerful its secreted venom."
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
            description = "An aggressive Pokémon that is quick to attack. The horn on its head secretes a powerful venom."
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
            description = "It uses its powerful tail in battle to smash, constrict, then break the prey's bones."
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
            description = "Its magical and cute appearance has many admirers. It is rare and found only in certain areas."
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
            description = "A timid fairy Pokémon that is rarely seen. It will run and hide the moment it senses people."
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
            description = "At the time of its birth, it has only one white tail. The tail separates into six if this Pokémon receives plenty of love."
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
            description = "Very smart and very vengeful. Grabbing one of its many tails could result in a 1000-year curse."
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
            description = "When its huge eyes light up, it sings a mysteriously soothing melody that lulls its enemies to sleep."
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
            description = "The body is soft and rubbery. When angered, it will suck in air and inflate itself to an enormous size."
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
            description = "Forms colonies in perpetually dark places. Uses ultrasonic waves to identify and locate targets."
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
            description = "Once it strikes, it will not stop draining energy from the victim even if it gets too heavy to fly."
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
            description = "During the day, it keeps its face buried in the ground. At night, it wanders around sowing its seeds."
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
            description = "The fluid that oozes from its mouth isn't drool. It is a nectar that is used to attract prey."
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
            description = "The larger its petals, the more toxic pollen it contains. Its big head is heavy and hard to hold up."
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
            description = "Burrows to suck tree roots. The mushrooms on its back grow by drawing nutrients from the bug host."
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
            description = "A host-parasite pair in which the bug host has been devoured by the mushroom on its back. It prefers dark places."
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
            description = "Lives in the shadows of tall trees where it eats insects. It is attracted by light at night."
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
            description = "The dust-like scales covering its wings are color-coded to indicate the kinds of poison they contain."
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
            description = "Lives about one yard underground where it feeds on plant roots. It sometimes appears above ground."
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
            description = "A team of Diglett triplets. It triggers huge earthquakes by burrowing 60 miles underground."
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
            description = "Adores circular objects. Wanders the streets on a nightly basis to look for dropped loose change."
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
            description = "Although its fur has many admirers, it is tough to raise as a pet because of its fickle meanness."
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
            description = "While lulling its enemies with its vacant look, this wily Pokémon will use psychokinetic powers."
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
            description = "Often seen swimming elegantly by lake shores. It is often mistaken for the Japanese monster Kappa."
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
            description = "Extremely quick to anger. It could be docile one moment then thrashing away the next instant."
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
            description = "Always furious and tenacious to boot. It will not abandon chasing its quarry until it is caught."
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
            description = "Very protective of its territory. It will bark and bite to repel intruders from its space."
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
            description = "A Pokémon that has been admired since the past for its beauty. It runs agilely as if on wings."
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
            description = "Its newly grown legs are unsteady. It seems to prefer swimming to walking on them."
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
            description = "Capable of living in or out of water. When out of water, it sweats to keep its body slimy."
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
            description = "An adept swimmer at both the front crawl and breaststroke. Easily overtakes the best human swimmers."
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
            description = "Using its ability to read minds, it will identify impending danger and Teleport to safety."
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
            description = "It emits special alpha waves from its body that induce headaches just by being close by."
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
            description = "Its brain can outperform a supercomputer. Its intelligence quotient is said to be 5,000."
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
            description = "Loves to build its muscles. It trains in all styles of martial arts to become even stronger."
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
            description = "Its muscular body is so powerful, it must wear a power save belt to help regulate its motions."
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
            description = "Using its four hugely muscular arms, it delivers a torrent of countless punches and chops at blinding speed."
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
            description = "A carnivorous Pokémon that traps and eats bugs. It uses its root feet to soak up needed moisture."
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
            description = "It spits out Poison Powder to immobilize the enemy and then finishes it with a spray of Acid."
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
            description = "Said to live in huge colonies deep in jungles, although no one has ever returned from there."
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
            description = "Drifts in shallow seas. Anglers who hook them by accident are often punished by its stingers."
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
            description = "The short tentacles stay coiled up at all times, but are extended to snare and stun prey."
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
            description = "Found in fields and mountains. Mistaking them for boulders, people often step on them or trip over them."
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
            description = "Rolls down slopes to move. It rolls over any obstacle without slowing down or changing its direction."
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
            description = "It is enclosed in a hard shell that is as rugged as slabs of rock. It sheds its skin once a year."
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
            description = "About an hour after birth, its fiery mane and tail grow out, giving it an impressive appearance."
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
            description = "At full gallop, its four hooves barely touch the ground because it moves so incredibly fast."
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
            description = "Incredibly slow and dopey. It takes five seconds for it to feel pain when under attack."
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
            description = "When a Shellder bites onto a Slowpoke's tail, it somehow evolves into a Slowbro."
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
            description = "Uses anti-gravity to stay suspended. Appears without warning and uses Thunder Wave and similar moves."
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
            description = "Formed by several Magnemites linked together. They frequently appear when sunspots flare up."
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
            description = "The sprig of green onions it holds is its weapon. It is used much like a metal sword."
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
            description = "A bird that makes up for its poor flying with its fast foot speed. Leaves giant footprints."
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
            description = "Uses its three heads to execute complex plans. While two heads sleep, one head stays awake."
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
            description = "The protruding horn on its head is very hard. It is used for bashing through thick ice."
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
            description = "Stores thermal energy within its body. It stays safe and active even in frigid water."
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
            description = "Appears in filthy areas. Thrives by sucking up polluted sludge that is pumped out of factories."
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
            description = "Thickly covered with a filthy, vile sludge. It is so toxic, even its footprints contain poison."
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
            description = "Its hard shell repels any kind of attack. It is vulnerable only when its shell is open."
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
            description = "When attacked, it launches its horns in quick succession. Its innards have never been seen."
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
            description = "Almost invisible, this gaseous Pokémon cloaks the target and puts it to sleep without notice."
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
            description = "Because of its ability to slip through block walls, it is said to be from another dimension."
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
            description = "Under a full moon, this Pokémon likes to mimic the shadows of people and laugh at their fright."
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
            description = "As it grows, the stone portions of its body harden to become similar to a diamond, but colored black."
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
            description = "Puts enemies to sleep then eats their dreams. Occasionally gets sick from eating bad dreams."
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
            description = "When it locks eyes with an enemy, it will use a mix of PSI moves such as Hypnosis and Confusion."
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
            description = "Its pincers are not only powerful weapons, they are used for balance when walking sideways."
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
            description = "The large pincer has 10,000 hp of crushing power. However, its huge size makes it unwieldy to use."
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
            description = "Usually found in power plants. Easily mistaken for a Poké Ball, it has zapped many people."
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
            description = "It stores electric energy under very high pressure. It often explodes with little or no provocation."
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
            description = "Often mistaken for eggs. When disturbed, they quickly gather and attack in swarms."
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
            description = "Legend has it that on rare occasions, one of its heads will drop off and continue on as an Exeggcute."
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
            description = "Because it never removes its skull helmet, no one has ever seen this Pokémon's real face."
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
            description = "The bone it holds is its primary weapon. It throws the bone skillfully like a boomerang to KO targets."
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
            description = "When in a hurry, its legs lengthen progressively. It runs smoothly with extra long, loping strides."
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
            description = "While apparently doing nothing, it fires punches in lightning fast bursts that are invisible to the eye."
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
            description = "Its tongue can be extended like a chameleon's. It leaves a tingling sensation when it licks enemies."
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
            description = "Because it stores several kinds of toxic gases in its body, it is prone to exploding without warning."
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
            description = "Where two kinds of poison gases fuse, two Koffings can fuse into a Weezing over many years."
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
            evolutions = listOf("rhyhorn", "rhydon", "rhyperior"),
            stats = listOf(
                PokemonStat("hp", 80), PokemonStat("attack", 85),
                PokemonStat("defense", 95), PokemonStat("special-attack", 30),
                PokemonStat("special-defense", 30), PokemonStat("speed", 25)
            ),
            description = "Its massive bones are 1000 times harder than human bones. It can easily knock a trailer truck flying."
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
            evolutions = listOf("rhyhorn", "rhydon", "rhyperior"),
            stats = listOf(
                PokemonStat("hp", 105), PokemonStat("attack", 130),
                PokemonStat("defense", 120), PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 45), PokemonStat("speed", 40)
            ),
            description = "Protected by an armor-like hide, it is capable of living in molten lava of 3,600 degrees."
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
            evolutions = listOf("happiny", "chansey", "blissey"),
            stats = listOf(
                PokemonStat("hp", 250), PokemonStat("attack", 5),
                PokemonStat("defense", 5), PokemonStat("special-attack", 35),
                PokemonStat("special-defense", 105), PokemonStat("speed", 50)
            ),
            description = "A gentle and kind-hearted Pokémon that shares its nutritious eggs if it sees an injured person."
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
            description = "The whole body is swathed with wide vines that are similar to seaweed. Its vines shake as it walks."
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
            description = "The infant rarely ventures out of its mother's protective pouch until it is three years old."
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
            description = "Known to shoot down flying bugs with precision blasts of ink from the surface of the water."
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
            description = "Capable of swimming backwards by rapidly flapping its wing-like pectoral fins and stout tail."
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
            description = "Its tail fin billows like an elegant ballroom dress, giving it the nickname of the Water Queen."
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
            description = "In the autumn spawning season, they can be seen swimming powerfully up rivers and creeks."
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
            description = "An enigmatic Pokémon that can effortlessly regenerate any appendage it loses in fight."
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
            description = "Its central core glows with the seven colors of the rainbow. Some people value the core as a gem."
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
            description = "If interrupted while it is miming, it will suddenly slap the offender with its broad hands."
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
            description = "With ninja-like agility and speed, it can create the illusion that there is more than one."
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
            description = "It seductively wiggles its hips as it walks. It can cause people to dance in unison with it."
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
            evolutions = listOf("electabuzz"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 83),
                PokemonStat("defense", 57), PokemonStat("special-attack", 95),
                PokemonStat("special-defense", 85), PokemonStat("speed", 105)
            ),
            description = "Normally found near power plants, they can wander away and cause major blackouts in cities."
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
            description = "Its body always burns with an orange glow that enables it to hide perfectly among flames."
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
            description = "If it fails to crush the victim in its pincers, it will swing it around and toss it hard."
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
            description = "When it targets an enemy, it charges furiously while whipping its body with its three long tails."
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
            description = "In the distant past, it was somewhat stronger than the horribly weak descendants that exist today."
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
            description = "Rarely seen in the wild. Huge and vicious, it is capable of destroying entire cities in a rage."
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
            description = "A Pokémon that has been overhunted almost to extinction. It can ferry people across the water."
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
            description = "Capable of copying an enemy's genetic code to instantly transform itself into a duplicate of the enemy."
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
            description = "Its genetic code is irregular. It may mutate if it is exposed to radiation from element Stones."
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
            description = "Lives close to water. Its long tail is ridged with a fin which is often mistaken for a mermaid's."
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
            description = "It accumulates negative ions from the atmosphere to blast out 10,000-volt lightning bolts."
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
            evolutions = listOf("eevee", "vaporeon", "jolteon", "flareon"),
            stats = listOf(
                PokemonStat("hp", 65), PokemonStat("attack", 130),
                PokemonStat("defense", 60), PokemonStat("special-attack", 95),
                PokemonStat("special-defense", 110), PokemonStat("speed", 65)
            ),
            description = "When storing thermal energy in its body, its temperature could soar to over 1,600 degrees."
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
            description = "A Pokémon that consists entirely of programming code. Capable of moving freely in cyberspace."
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
            description = "An ancient Pokémon that was recovered from a fossil. It uses its 10 tentacles to swim about."
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
            description = "A prehistoric Pokémon that died out when its heavy shell made it too slow to catch prey."
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
            description = "A Pokémon that was resurrected from a fossil found in what was once the ocean floor eons ago."
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
            description = "Its sleek shape is perfect for swimming. It slashes prey with its claws and drains the body fluids."
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
            description = "A ferocious, prehistoric Pokémon that goes for the enemy's throat with its serrated saw-like teeth."
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
            description = "Very lazy. Just eats and sleeps. As its rotund bulk builds, it becomes steadily more slothful."
        ),
        Pokemon(
            id = 144,
            name = "articuno",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/144.png",
            types = listOf("ice", "flying"),
            height = 1.7,
            weight = 55.4,
            abilities = listOf("pressure", "snow-cloak"),
            gender = "genderless",
            weaknesses = listOf("rock", "fire", "electric", "steel"),
            evolutions = listOf("articuno"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 85),
                PokemonStat("defense", 100), PokemonStat("special-attack", 95),
                PokemonStat("special-defense", 125), PokemonStat("speed", 85)
            ),
            description = "A legendary bird Pokémon that is said to appear to doomed people who are lost in icy mountains."
        ),
        Pokemon(
            id = 145,
            name = "zapdos",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/145.png",
            types = listOf("electric", "flying"),
            height = 1.6,
            weight = 52.6,
            abilities = listOf("pressure", "static"),
            gender = "genderless",
            weaknesses = listOf("ice", "rock"),
            evolutions = listOf("zapdos"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 90),
                PokemonStat("defense", 85), PokemonStat("special-attack", 125),
                PokemonStat("special-defense", 90), PokemonStat("speed", 100)
            ),
            description = "A legendary bird Pokémon that is said to appear from clouds while wielding enormous lightning bolts."
        ),
        Pokemon(
            id = 146,
            name = "moltres",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/146.png",
            types = listOf("fire", "flying"),
            height = 2.0,
            weight = 60.0,
            abilities = listOf("pressure", "flame-body"),
            gender = "genderless",
            weaknesses = listOf("rock", "water", "electric"),
            evolutions = listOf("moltres"),
            stats = listOf(
                PokemonStat("hp", 90), PokemonStat("attack", 100),
                PokemonStat("defense", 90), PokemonStat("special-attack", 125),
                PokemonStat("special-defense", 85), PokemonStat("speed", 90)
            ),
            description = "Known as the legendary bird of fire. Every flap of its wings creates a dazzling flash of flames."
        ),
        Pokemon(
            id = 147,
            name = "dratini",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/147.png",
            types = listOf("dragon"),
            height = 1.8,
            weight = 3.3,
            abilities = listOf("shed-skin", "marvel-scale"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ice", "dragon", "fairy"),
            evolutions = listOf("dratini", "dragonair", "dragonite"),
            stats = listOf(
                PokemonStat("hp", 41), PokemonStat("attack", 64),
                PokemonStat("defense", 45), PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 50), PokemonStat("speed", 50)
            ),
            description = "Long considered a mythical Pokémon until recently, when a small colony was found living underwater."
        ),
        Pokemon(
            id = 148,
            name = "dragonair",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/148.png",
            types = listOf("dragon"),
            height = 4.0,
            weight = 16.5,
            abilities = listOf("shed-skin", "marvel-scale"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ice", "dragon", "fairy"),
            evolutions = listOf("dratini", "dragonair", "dragonite"),
            stats = listOf(
                PokemonStat("hp", 61), PokemonStat("attack", 84),
                PokemonStat("defense", 65), PokemonStat("special-attack", 70),
                PokemonStat("special-defense", 70), PokemonStat("speed", 70)
            ),
            description = "A mystical Pokémon that exudes a gentle aura. Has the ability to change climate conditions freely."
        ),
        Pokemon(
            id = 149,
            name = "dragonite",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/149.png",
            types = listOf("dragon", "flying"),
            height = 2.2,
            weight = 210.0,
            abilities = listOf("inner-focus", "multiscale"),
            gender = "50% M, 50% F",
            weaknesses = listOf("ice", "rock", "dragon", "fairy"),
            evolutions = listOf("dratini", "dragonair", "dragonite"),
            stats = listOf(
                PokemonStat("hp", 91), PokemonStat("attack", 134),
                PokemonStat("defense", 95), PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 100), PokemonStat("speed", 80)
            ),
            description = "An extremely rarely seen marine Pokémon. Its intelligence is said to match that of humans."
        ),
        Pokemon(
            id = 150,
            name = "mewtwo",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png",
            types = listOf("psychic"),
            height = 2.0,
            weight = 122.0,
            abilities = listOf("pressure", "unnerve"),
            gender = "genderless",
            weaknesses = listOf("bug", "ghost", "dark"),
            evolutions = listOf("mewtwo"),
            stats = listOf(
                PokemonStat("hp", 106), PokemonStat("attack", 110),
                PokemonStat("defense", 90), PokemonStat("special-attack", 154),
                PokemonStat("special-defense", 90), PokemonStat("speed", 130)
            ),
            description = "It was created by a scientist after years of horrific gene splicing and DNA engineering experiments."
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
            description = "So rare that it is still said to be a mirage by many experts. Only a few people have seen it worldwide."
        )
    )

    fun findById(id: Int): Pokemon? = pokedex.firstOrNull { it.id == id }
}