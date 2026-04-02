import { createBrowserRouter } from "react-router";
import { Home } from "./components/home";
import { PokedexList } from "./components/pokedex-list";
import { PokemonDetails } from "./components/pokemon-details";
import { TeamBuilder } from "./components/team-builder";

export const router = createBrowserRouter([
  {
    path: "/",
    Component: Home,
  },
  {
    path: "/pokedex",
    Component: PokedexList,
  },
  {
    path: "/pokemon/:id",
    Component: PokemonDetails,
  },
  {
    path: "/team",
    Component: TeamBuilder,
  },
]);
