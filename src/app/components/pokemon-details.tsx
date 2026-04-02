import { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router";
import { Plus, Check, FileText, Leaf } from "lucide-react";
import { pokemonData } from "../data/pokemon";
import { TypeBadge } from "./type-badge";
import { Scaffold } from "./scaffold";

export function PokemonDetails() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [isInTeam, setIsInTeam] = useState(false);
  const [team, setTeam] = useState<number[]>([]);

  const pokemon = pokemonData.find((p) => p.id === Number(id));

  useEffect(() => {
    const savedTeam = localStorage.getItem("pokemonTeam");
    if (savedTeam) {
      const teamIds = JSON.parse(savedTeam);
      setTeam(teamIds);
      setIsInTeam(teamIds.includes(Number(id)));
    }
  }, [id]);

  if (!pokemon) {
    return (
      <Scaffold title="ERROR" showBack>
        <div className="min-h-screen flex items-center justify-center">
          <div className="text-center bg-white/40 backdrop-blur-lg p-8 rounded-3xl border-3 border-white/60 shadow-2xl m-4">
            <h2 className="text-2xl mb-4 text-green-900">Pokémon not found</h2>
            <button 
              onClick={() => navigate("/pokedex")}
              className="text-green-600 hover:underline"
            >
              Back to Pokédex
            </button>
          </div>
        </div>
      </Scaffold>
    );
  }

  const handleAddToTeam = () => {
    if (isInTeam) {
      const newTeam = team.filter((pokemonId) => pokemonId !== pokemon.id);
      setTeam(newTeam);
      setIsInTeam(false);
      localStorage.setItem("pokemonTeam", JSON.stringify(newTeam));
    } else {
      if (team.length >= 6) {
        alert("Team is full! Remove a Pokémon first.");
        return;
      }
      const newTeam = [...team, pokemon.id];
      setTeam(newTeam);
      setIsInTeam(true);
      localStorage.setItem("pokemonTeam", JSON.stringify(newTeam));
    }
  };

  const maxStat = Math.max(...Object.values(pokemon.stats));

  return (
    <Scaffold title={pokemon.name.toUpperCase()} showBack>
      <div className="relative overflow-hidden">
        {/* Decorative elements */}
        <div className="absolute top-20 right-10 w-32 h-32 bg-emerald-300/20 rounded-full blur-3xl" />
        <div className="absolute bottom-32 left-10 w-40 h-40 bg-lime-300/20 rounded-full blur-3xl" />
        <div className="absolute top-1/3 left-1/4 opacity-5">
          <Leaf className="w-48 h-48 text-green-600 -rotate-12" />
        </div>

        <div className="container mx-auto px-4 py-6 relative z-10 max-w-md">
          {/* Main Card - Glassmorphism */}
          <div className="bg-white/30 backdrop-blur-lg border-3 border-white/50 rounded-3xl shadow-2xl overflow-hidden">
            {/* Header Section */}
            <div className="bg-gradient-to-br from-emerald-500 to-green-600 p-6 relative overflow-hidden">
              {/* Decorative elements */}
              <div className="absolute top-4 right-4 w-4 h-4 bg-[#76ff03] rounded-full shadow-lg shadow-[#76ff03]/50" />
              <div className="absolute top-4 right-12 w-3 h-3 bg-[#ffea00] rounded-full shadow-lg shadow-[#ffea00]/50" />
              <div className="absolute top-4 right-20 w-3 h-3 bg-[#00e5ff] rounded-full shadow-lg shadow-[#00e5ff]/50" />
              
              <div className="flex items-center justify-between mb-4">
                <div>
                  <div 
                    className="text-[#76ff03] mb-2 text-sm"
                    style={{ fontFamily: "'Press Start 2P', cursive" }}
                  >
                    {pokemon.number}
                  </div>
                  <h1 className="text-4xl text-white drop-shadow-lg">{pokemon.name}</h1>
                </div>
                <div className="bg-white/20 backdrop-blur-sm p-2 rounded-2xl border-2 border-white/40">
                  <img
                    src={pokemon.image}
                    alt={pokemon.name}
                    className="w-28 h-28 object-contain drop-shadow-2xl"
                  />
                </div>
              </div>
              
              <div className="flex gap-2 flex-wrap">
                {pokemon.types.map((type) => (
                  <TypeBadge key={type} type={type} />
                ))}
              </div>
            </div>

            {/* Content Section */}
            <div className="p-6 space-y-6">
              {/* Description */}
              <div className="bg-white/40 backdrop-blur-sm border-2 border-white/60 rounded-2xl p-4">
                <div className="flex items-center gap-2 mb-2">
                  <FileText className="w-5 h-5 text-green-600" />
                  <h2 className="text-lg text-green-900">Description</h2>
                </div>
                <p className="text-green-800 leading-relaxed text-sm">
                  {pokemon.description}
                </p>
              </div>

              {/* Stats - Retro game style */}
              <div className="bg-white/40 backdrop-blur-sm border-2 border-white/60 rounded-2xl p-4">
                <h2 className="text-lg text-green-900 mb-4">Stats</h2>
                <div className="space-y-3">
                  <StatBar label="HP" value={pokemon.stats.hp} max={maxStat} color="from-red-500 to-pink-500" neonColor="#ff1744" />
                  <StatBar label="ATK" value={pokemon.stats.attack} max={maxStat} color="from-orange-500 to-amber-500" neonColor="#ffa726" />
                  <StatBar label="DEF" value={pokemon.stats.defense} max={maxStat} color="from-yellow-500 to-yellow-400" neonColor="#ffea00" />
                  <StatBar label="SP.ATK" value={pokemon.stats.specialAttack} max={maxStat} color="from-blue-500 to-cyan-500" neonColor="#42a5f5" />
                  <StatBar label="SP.DEF" value={pokemon.stats.specialDefense} max={maxStat} color="from-green-500 to-emerald-500" neonColor="#66bb6a" />
                  <StatBar label="SPD" value={pokemon.stats.speed} max={maxStat} color="from-purple-500 to-pink-500" neonColor="#ab47bc" />
                </div>
              </div>

              {/* Action Buttons */}
              <div className="space-y-3">
                <button
                  onClick={handleAddToTeam}
                  className={`w-full py-4 rounded-2xl font-medium text-lg transition-all duration-300 flex items-center justify-center gap-2 border-3 shadow-lg ${
                    isInTeam
                      ? "bg-gradient-to-r from-green-500 to-emerald-600 hover:from-green-600 hover:to-emerald-700 text-white border-white/50 shadow-green-500/50"
                      : "bg-gradient-to-r from-teal-500 to-cyan-600 hover:from-teal-600 hover:to-cyan-700 text-white border-white/50 shadow-teal-500/50"
                  }`}
                >
                  {isInTeam ? (
                    <>
                      <Check className="w-6 h-6" />
                      <span>In Team</span>
                    </>
                  ) : (
                    <>
                      <Plus className="w-6 h-6" />
                      <span>Add to Team</span>
                    </>
                  )}
                </button>
                
                <button
                  onClick={() => navigate("/team")}
                  className="w-full py-4 bg-white/60 backdrop-blur-sm hover:bg-white/80 border-3 border-white/60 rounded-2xl font-medium text-lg transition-all text-green-900 shadow-lg"
                >
                  View Team
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </Scaffold>
  );
}

interface StatBarProps {
  label: string;
  value: number;
  max: number;
  color: string;
  neonColor: string;
}

function StatBar({ label, value, max, color, neonColor }: StatBarProps) {
  const percentage = (value / max) * 100;

  return (
    <div>
      <div className="flex justify-between mb-1.5">
        <span 
          className="text-green-900 text-xs uppercase tracking-wider"
          style={{ fontFamily: "'Press Start 2P', cursive" }}
        >
          {label}
        </span>
        <span 
          className="text-green-700 text-sm"
          style={{ fontFamily: "'Press Start 2P', cursive" }}
        >
          {value}
        </span>
      </div>
      <div className="w-full bg-green-900/20 rounded-full h-4 overflow-hidden border-2 border-green-900/30 shadow-inner">
        <div
          className={`bg-gradient-to-r ${color} h-full rounded-full transition-all duration-700 border-r-2 border-white/50`}
          style={{ 
            width: `${percentage}%`,
            boxShadow: `0 0 10px ${neonColor}80`
          }}
        />
      </div>
    </div>
  );
}