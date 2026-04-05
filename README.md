# Pokédex Multiplatform

Projeto acadêmico em **Kotlin Multiplatform** e **Compose Multiplatform** para Android e iOS.

O app simula uma Pokédex moderna com navegação tipada, telas compartilhadas entre plataformas, lista de Pokémon em grade, tela de detalhes, adição ao time e uma tela de **Team Builder** com implementação diferente para cada sistema operacional.

## Visão geral

- **Home**: dashboard inicial com atalhos para Pokédex e Meu Time.
- **Pokédex**: listagem de Pokémon em `LazyVerticalGrid`, com busca, cards em `ElevatedCard` e gradientes por tipo.
- **Detalhes do Pokémon**: exibe descrição, tipos, atributos, barra de progresso dos stats e botão para adicionar ao time.
- **Meu Time / Team Builder**: lista os Pokémon selecionados e exibe um resumo do time.

## Stack

- Kotlin Multiplatform
- Compose Multiplatform
- Material 3
- Navegação tipada com `@Serializable`
- `expect/actual` para diferenciar a tela de Team Builder por plataforma
- Dados mockados em `PokemonMock`

## Estrutura principal

O código compartilhado fica em `composeApp/src/commonMain` e está organizado em:

- `data`: modelos e mock de Pokémon
- `navigation`: rotas tipadas
- `ui`: telas, componentes e helpers de interface

As implementações específicas ficam em:

- `composeApp/src/androidMain`: UI do Android
- `composeApp/src/iosMain`: UI do iOS

## Navegação

O fluxo principal do app é:

1. `HomeRoute`
2. `PokedexRoute`
3. `PokemonDetailRoute(pokemonId)`
4. `MyTeamRoute`

O `Scaffold` centraliza a estrutura visual com:

- `topBar` dinâmica, com título variando conforme a rota atual
- `bottomBar` para alternar entre **Pokédex** e **Meu Time**

## Diferenças entre Android e iOS

### Android

- Tela de Team Builder com visual inspirado em **Material Design 3**
- Cores, superfícies e gradientes mais próximos da linguagem do Android
- Mantém o comportamento compartilhado de adicionar/remover Pokémon do time

### iOS

- Tela de Team Builder com estética mais próxima das **Human Interface Guidelines**
- Layout e tons visuais mais leves, com identidade própria para a plataforma
- Usa a mesma lógica de estado compartilhado, mas com aparência adaptada ao iOS

## Funcionalidades principais

- navegação tipada entre telas
- mock de Pokémon com múltiplos tipos e atributos
- busca na Pokédex
- cards com gradientes baseados nos tipos
- tela de detalhes com stats e botão de adicionar ao time
- limite de até 6 Pokémon no time
- visual diferenciado para Android e iOS na tela de Team Builder
