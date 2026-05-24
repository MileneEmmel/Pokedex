# Pokédex Multiplatform

Autores: Milene Emmel Rovedder e Daniel Henrique Da Silva

Projeto acadêmico em **Kotlin Multiplatform** e **Compose Multiplatform** para Android e iOS, agora utilizando uma arquitetura **Offline-First** com **PokeAPI** e **Room Database**.

O app simula uma Pokédex moderna com navegação tipada, telas compartilhadas entre plataformas, lista de Pokémon em grade, tela de detalhes, adição ao time e uma tela de **Team Builder** com implementação diferente para cada sistema operacional.

## Visão geral

- **Home**: dashboard inicial com atalhos para Pokédex e Meu Time.
- **Pokédex**: listagem real via **PokeAPI** com paginação dinâmica, busca por nome/ID e filtros por tipo.
- **Detalhes do Pokémon**: exibe descrição, tipos, atributos reais (stats), cadeia de evolução recursiva e localização de captura.
- **Meu Time / Team Builder**: gerencia até 6 Pokémon com persistência local total via Room.

## Stack

- Kotlin Multiplatform
- Compose Multiplatform
- **Ktor**: Consumo da PokeAPI
- **Room Database**: Cache local e persistência do time (Offline-First)
- Material 3
- Navegação tipada com `@Serializable`
- `expect/actual` para diferenciar a tela de Team Builder por plataforma

## Estrutura principal

O código compartilhado fica em `composeApp/src/commonMain` e está organizado em:

- **data**: modelos, repositórios e acesso a dados (API / Banco de Dados)
- **navigation**: rotas tipadas e grafo de navegação
- **ui**: telas reativas, ViewModels e componentes de interface

As implementações específicas ficam em:

- `composeApp/src/androidMain`: UI do Android
- `composeApp/src/iosMain`: UI do iOS

## Navegação

O fluxo principal do app é:

1. `HomeRoute`
2. `PokedexRoute`
3. `PokemonDetailRoute(id)`
4. `MyTeamRoute`

O `Scaffold` centraliza a estrutura visual com:

- `topBar` dinâmica, com título variando conforme a rota atual
- `bottomBar` para alternar entre **Pokédex** e **Meu Time**

## Diferenças entre Android e iOS

### Android

- Tela de Team Builder com visual inspirado em **Material Design 3**
- Cores, superfícies e gradientes dinâmicos baseados nos tipos do Pokémon
- Mantém o comportamento compartilhado de adicionar/remover Pokémon do time

### iOS

- Tela de Team Builder com estética mais próxima das **Human Interface Guidelines**
- Layout e tons visuais mais leves, com identidade própria para a plataforma
- Usa a mesma lógica de estado compartilhado, mas com aparência adaptada ao iOS

## Funcionalidades principais

- Navegação tipada entre telas
- **Integração com PokeAPI**: Dados reais e em tempo real
- **Arquitetura Offline-First**: Sincronização e cache de dados no Room para funcionamento sem internet
- **Paginação Real**: Carregamento sob demanda (Lazy Loading) na listagem principal
- **Busca e Filtros Reativos**: Atualização instantânea da UI ao pesquisar ou filtrar tipos
- **Persistência de Atributos**: Stats completos e local de captura salvos permanentemente no time
- **Evolução Completa**: Mapeamento de toda a cadeia evolutiva via API
- Visual diferenciado para Android e iOS na tela de Team Builder
