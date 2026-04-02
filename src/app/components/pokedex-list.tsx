import { useState } from "react";
import { Search, Filter, X, Leaf } from "lucide-react";
import { pokemonData } from "../data/pokemon";
import { PokemonCard } from "./pokemon-card";
import { Scaffold } from "./scaffold";

const allTypes = [
  "Fire", "Water", "Grass", "Electric", "Psychic", 
  "Dragon", "Ghost", "Poison", "Flying", "Normal", "Ice"
];

export function PokedexList() {
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedType, setSelectedType] = useState<string | null>(null);
  const [showTypeFilter, setShowTypeFilter] = useState(false);

  const filteredPokemon = pokemonData.filter((pokemon) => {
    const matchesSearch = pokemon.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
      pokemon.number.includes(searchTerm);
    const matchesType = !selectedType || pokemon.types.includes(selectedType);
    return matchesSearch && matchesType;
  });

  return (
    <Scaffold title="POKÉDEX">
      <div className="relative overflow-hidden">
        {/* Decorative background elements */}
        <div className="absolute top-10 right-10 w-40 h-40 bg-emerald-300/20 rounded-full blur-3xl" />
        <div className="absolute bottom-20 left-20 w-48 h-48 bg-lime-300/20 rounded-full blur-3xl" />
        <div className="absolute top-1/2 right-1/4 opacity-5">
          <Leaf className="w-40 h-40 text-green-600 rotate-12" />
        </div>

        <div className="container mx-auto px-4 py-6 relative z-10 max-w-md">
          {/* Search and Filter Section */}
          <div className="mb-6 space-y-3">
            {/* Stats display */}
            <div className="bg-white/30 backdrop-blur-lg border-3 border-white/50 rounded-2xl p-4 shadow-xl">
              <div className="flex items-center justify-between">
                <span className="text-green-800">Database</span>
                <span 
                  className="text-green-900 text-xl"
                  style={{ fontFamily: "'Press Start 2P', cursive" }}
                >
                  {filteredPokemon.length}/{pokemonData.length}
                </span>
              </div>
            </div>

            {/* Search Bar */}
            <div className="relative">
              <div className="bg-white/40 backdrop-blur-lg border-3 border-white/60 rounded-2xl shadow-lg overflow-hidden">
                <div className="relative">
                  <Search className="absolute left-4 top-1/2 transform -translate-y-1/2 text-green-600 w-5 h-5" />
                  <input
                    type="text"
                    placeholder="Search Pokémon..."
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    className="w-full pl-12 pr-4 py-3 bg-transparent focus:outline-none text-green-900 placeholder-green-600/60"
                  />
                </div>
              </div>
            </div>

            {/* Filter Button */}
            <button
              onClick={() => setShowTypeFilter(!showTypeFilter)}
              className={`w-full py-3 rounded-2xl transition-all border-3 flex items-center justify-center gap-2 ${
                selectedType
                  ? "bg-gradient-to-r from-emerald-500 to-green-600 text-white border-white/50 shadow-lg shadow-emerald-500/30"
                  : "bg-white/40 backdrop-blur-lg border-white/60 text-green-800 hover:bg-white/60"
              }`}
            >
              <Filter className="w-5 h-5" />
              <span className="font-medium">
                {selectedType ? `Type: ${selectedType}` : "Filter by Type"}
              </span>
              {selectedType && (
                <X 
                  className="w-4 h-4" 
                  onClick={(e) => {
                    e.stopPropagation();
                    setSelectedType(null);
                  }}
                />
              )}
            </button>

            {/* Type Filter Chips */}
            {showTypeFilter && (
              <div className="bg-white/40 backdrop-blur-lg border-3 border-white/60 rounded-2xl p-4 shadow-xl animate-in slide-in-from-top-2">
                <div className="flex flex-wrap gap-2">
                  {allTypes.map((type) => (
                    <button
                      key={type}
                      onClick={() => {
                        setSelectedType(type === selectedType ? null : type);
                        setShowTypeFilter(false);
                      }}
                      className={`px-3 py-2 rounded-xl text-xs font-medium border-2 transition-all ${
                        selectedType === type
                          ? "bg-gradient-to-br from-emerald-500 to-green-600 text-white border-white/50 shadow-lg scale-105"
                          : "bg-white/60 text-green-800 border-white/80 hover:bg-white/80"
                      }`}
                    >
                      {type}
                    </button>
                  ))}
                </div>
              </div>
            )}
          </div>

          {/* Pokemon Grid */}
          <div className="grid grid-cols-2 gap-4 pb-6">
            {filteredPokemon.map((pokemon) => (
              <PokemonCard key={pokemon.id} pokemon={pokemon} />
            ))}
          </div>

          {filteredPokemon.length === 0 && (
            <div className="text-center py-16">
              <div className="bg-white/30 backdrop-blur-lg border-3 border-white/50 rounded-3xl p-8 shadow-xl">
                <p className="text-green-700 text-lg mb-2">No Pokémon found</p>
                <p className="text-green-600 text-sm mb-4">
                  Try a different search or filter
                </p>
                {(searchTerm || selectedType) && (
                  <button
                    onClick={() => {
                      setSearchTerm("");
                      setSelectedType(null);
                    }}
                    className="px-4 py-2 bg-gradient-to-r from-emerald-500 to-green-600 text-white rounded-xl text-sm font-medium border-2 border-white/50 shadow-lg hover:from-emerald-600 hover:to-green-700 transition-all"
                  >
                    Clear Filters
                  </button>
                )}
              </div>
            </div>
          )}
        </div>
      </div>
    </Scaffold>
  );
}
