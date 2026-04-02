import { Link } from "react-router";
import { Pokemon } from "../data/pokemon";
import { TypeBadge } from "./type-badge";

interface PokemonCardProps {
  pokemon: Pokemon;
}

export function PokemonCard({ pokemon }: PokemonCardProps) {
  return (
    <Link
      to={`/pokemon/${pokemon.id}`}
      className="group block"
    >
      <div className="bg-white/30 backdrop-blur-lg border-3 border-white/50 rounded-3xl shadow-xl hover:shadow-2xl hover:shadow-green-400/30 transition-all duration-300 hover:scale-105 overflow-hidden relative h-full flex flex-col">
        {/* Decorative corner elements */}
        <div className="absolute top-2 right-2 w-3 h-3 bg-[#76ff03] rounded-full shadow-lg shadow-[#76ff03]/50" />
        <div className="absolute top-2 left-2 w-3 h-3 bg-[#ffea00] rounded-full shadow-lg shadow-[#ffea00]/50" />
        
        {/* Image container with gradient */}
        <div className="bg-gradient-to-br from-green-100/50 to-emerald-200/50 p-6 flex items-center justify-center h-40 relative backdrop-blur-sm">
          <img
            src={pokemon.image}
            alt={pokemon.name}
            className="w-28 h-28 object-contain drop-shadow-2xl group-hover:scale-110 transition-transform duration-300"
          />
          
          {/* Pokemon number badge - retro style */}
          <div className="absolute top-2 left-2 bg-green-900/70 backdrop-blur-sm px-2 py-1 rounded-lg border-2 border-[#76ff03]/50">
            <span 
              className="text-[#76ff03] text-xs"
              style={{ fontFamily: "'Press Start 2P', cursive" }}
            >
              {pokemon.number}
            </span>
          </div>
        </div>
        
        <div className="p-4 bg-white/20 backdrop-blur-sm flex-1 flex flex-col">
          <h3 className="text-xl mb-3 text-green-900 drop-shadow-sm min-h-[2rem] line-clamp-1">{pokemon.name}</h3>
          
          <div className="flex gap-2 flex-wrap min-h-[2.5rem]">
            {pokemon.types.map((type) => (
              <TypeBadge key={type} type={type} />
            ))}
          </div>
        </div>

        {/* Hover effect glow */}
        <div className="absolute inset-0 bg-gradient-to-br from-[#76ff03]/0 to-[#76ff03]/0 group-hover:from-[#76ff03]/10 group-hover:to-transparent transition-all duration-300 rounded-3xl pointer-events-none" />
      </div>
    </Link>
  );
}