import { useState, useEffect, useRef } from "react";
import { Link } from "react-router";
import { Target, Leaf, TrendingUp } from "lucide-react";
import { pokemonData } from "../data/pokemon";
import { TypeBadge } from "./type-badge";
import { Scaffold } from "./scaffold";

export function TeamBuilder() {
  const [team, setTeam] = useState<number[]>([]);

  useEffect(() => {
    const savedTeam = localStorage.getItem("pokemonTeam");
    if (savedTeam) {
      setTeam(JSON.parse(savedTeam));
    }
  }, []);

  const handleRemove = (pokemonId: number) => {
    const newTeam = team.filter((id) => id !== pokemonId);
    setTeam(newTeam);
    localStorage.setItem("pokemonTeam", JSON.stringify(newTeam));
  };

  const teamPokemon = team.map((id) => pokemonData.find((p) => p.id === id)).filter(Boolean);

  return (
    <Scaffold title="MY TEAM">
      <div className="relative overflow-hidden">
        {/* Decorative background */}
        <div className="absolute top-10 left-10 w-40 h-40 bg-emerald-300/20 rounded-full blur-3xl" />
        <div className="absolute bottom-20 right-20 w-48 h-48 bg-lime-300/20 rounded-full blur-3xl" />
        <div className="absolute top-1/3 right-1/4 opacity-5">
          <Leaf className="w-40 h-40 text-green-600 rotate-45" />
        </div>

        <div className="container mx-auto px-4 py-6 relative z-10 max-w-md">
          {/* Team Stats Card - Combined with Team Size */}
          <div className="bg-white/30 backdrop-blur-lg border-3 border-white/50 rounded-3xl shadow-2xl p-6 mb-6">
            {/* Team Size */}
            <div className="bg-green-900/50 rounded-xl p-3 border-2 border-green-700/50 mb-4">
              <div className="flex items-center justify-between">
                <span className="text-white text-sm">Team Size</span>
                <span 
                  className="text-[#76ff03] text-2xl"
                  style={{ fontFamily: "'Press Start 2P', cursive" }}
                >
                  {team.length}/6
                </span>
              </div>
            </div>

            {/* Stats Summary - Only show if team has pokemon */}
            {teamPokemon.length > 0 && (
              <div>
                <div className="flex items-center gap-2 mb-3">
                  <TrendingUp className="w-5 h-5 text-green-600" />
                  <h2 
                    className="text-base text-green-900"
                    style={{ fontFamily: "'Press Start 2P', cursive" }}
                  >
                    AVG STATS
                  </h2>
                </div>
                
                <div className="bg-green-900/50 rounded-xl p-3 border-2 border-green-700/50">
                  <div className="grid grid-cols-4 gap-2">
                    <div className="text-center">
                      <div 
                        className="text-2xl mb-1 text-[#ff1744]"
                        style={{ fontFamily: "'Press Start 2P', cursive" }}
                      >
                        {Math.round(teamPokemon.reduce((sum, p) => sum + p!.stats.hp, 0) / teamPokemon.length)}
                      </div>
                      <div className="text-white/80 text-xs">HP</div>
                    </div>
                    
                    <div className="text-center">
                      <div 
                        className="text-2xl mb-1 text-[#ffa726]"
                        style={{ fontFamily: "'Press Start 2P', cursive" }}
                      >
                        {Math.round(teamPokemon.reduce((sum, p) => sum + p!.stats.attack, 0) / teamPokemon.length)}
                      </div>
                      <div className="text-white/80 text-xs">ATK</div>
                    </div>
                    
                    <div className="text-center">
                      <div 
                        className="text-2xl mb-1 text-[#ffea00]"
                        style={{ fontFamily: "'Press Start 2P', cursive" }}
                      >
                        {Math.round(teamPokemon.reduce((sum, p) => sum + p!.stats.defense, 0) / teamPokemon.length)}
                      </div>
                      <div className="text-white/80 text-xs">DEF</div>
                    </div>
                    
                    <div className="text-center">
                      <div 
                        className="text-2xl mb-1 text-[#ab47bc]"
                        style={{ fontFamily: "'Press Start 2P', cursive" }}
                      >
                        {Math.round(teamPokemon.reduce((sum, p) => sum + p!.stats.speed, 0) / teamPokemon.length)}
                      </div>
                      <div className="text-white/80 text-xs">SPD</div>
                    </div>
                  </div>
                </div>
              </div>
            )}
          </div>

          {/* Team Grid */}
          {teamPokemon.length > 0 ? (
            <div className="space-y-3 mb-6">
              {teamPokemon.map((pokemon) => (
                <SwipeableCard
                  key={pokemon!.id}
                  pokemon={pokemon!}
                  onRemove={() => handleRemove(pokemon!.id)}
                />
              ))}
            </div>
          ) : (
            <div className="text-center py-12">
              <div className="bg-white/30 backdrop-blur-lg border-3 border-white/50 rounded-3xl p-8 shadow-2xl">
                <div className="bg-white/40 backdrop-blur-sm w-24 h-24 rounded-full flex items-center justify-center mx-auto mb-4 border-3 border-white/60">
                  <Target className="w-12 h-12 text-green-600" />
                </div>
                <h2 className="text-2xl text-green-900 mb-3">Team Empty</h2>
                <p className="text-green-700 mb-6 text-sm">
                  Add Pokémon from the Pokédex!
                </p>
                <Link
                  to="/pokedex"
                  className="inline-flex items-center gap-2 px-6 py-3 bg-gradient-to-r from-emerald-500 to-green-600 hover:from-emerald-600 hover:to-green-700 text-white rounded-2xl font-medium transition-all border-3 border-white/50 shadow-lg shadow-emerald-500/30"
                >
                  <Target className="w-5 h-5" />
                  <span>Explore Pokédex</span>
                </Link>
              </div>
            </div>
          )}
        </div>
      </div>
    </Scaffold>
  );
}

interface SwipeableCardProps {
  pokemon: any;
  onRemove: () => void;
}

function SwipeableCard({ pokemon, onRemove }: SwipeableCardProps) {
  const [touchStart, setTouchStart] = useState(0);
  const [touchEnd, setTouchEnd] = useState(0);
  const [offsetX, setOffsetX] = useState(0);
  const [isDragging, setIsDragging] = useState(false);
  const cardRef = useRef<HTMLDivElement>(null);

  const minSwipeDistance = 100;

  const onTouchStart = (e: React.TouchEvent) => {
    setTouchEnd(0);
    setTouchStart(e.targetTouches[0].clientX);
    setIsDragging(true);
  };

  const onTouchMove = (e: React.TouchEvent) => {
    const currentTouch = e.targetTouches[0].clientX;
    setTouchEnd(currentTouch);
    const distance = touchStart - currentTouch;
    if (distance > 0) {
      setOffsetX(-distance);
    }
  };

  const onTouchEnd = () => {
    setIsDragging(false);
    if (!touchStart || !touchEnd) {
      setOffsetX(0);
      return;
    }

    const distance = touchStart - touchEnd;
    const isLeftSwipe = distance > minSwipeDistance;

    if (isLeftSwipe) {
      // Animate out
      setOffsetX(-400);
      setTimeout(() => {
        onRemove();
      }, 300);
    } else {
      setOffsetX(0);
    }
  };

  const onMouseDown = (e: React.MouseEvent) => {
    setTouchEnd(0);
    setTouchStart(e.clientX);
    setIsDragging(true);
  };

  const onMouseMove = (e: React.MouseEvent) => {
    if (!isDragging) return;
    const currentX = e.clientX;
    setTouchEnd(currentX);
    const distance = touchStart - currentX;
    if (distance > 0) {
      setOffsetX(-distance);
    }
  };

  const onMouseUp = () => {
    setIsDragging(false);
    if (!touchStart || !touchEnd) {
      setOffsetX(0);
      return;
    }

    const distance = touchStart - touchEnd;
    const isLeftSwipe = distance > minSwipeDistance;

    if (isLeftSwipe) {
      setOffsetX(-400);
      setTimeout(() => {
        onRemove();
      }, 300);
    } else {
      setOffsetX(0);
    }
  };

  return (
    <div className="relative overflow-hidden rounded-3xl">
      {/* Delete background */}
      <div className="absolute inset-0 bg-gradient-to-l from-red-500 to-pink-600 flex items-center justify-end px-6 rounded-3xl">
        <span className="text-white font-bold text-lg">DELETE</span>
      </div>

      {/* Main card */}
      <div
        ref={cardRef}
        onTouchStart={onTouchStart}
        onTouchMove={onTouchMove}
        onTouchEnd={onTouchEnd}
        onMouseDown={onMouseDown}
        onMouseMove={onMouseMove}
        onMouseUp={onMouseUp}
        onMouseLeave={() => {
          if (isDragging) {
            onMouseUp();
          }
        }}
        style={{
          transform: `translateX(${offsetX}px)`,
          transition: isDragging ? 'none' : 'transform 0.3s ease-out',
        }}
        className="bg-white/30 backdrop-blur-lg border-3 border-white/50 rounded-3xl shadow-xl overflow-hidden relative cursor-grab active:cursor-grabbing select-none"
      >
        {/* Decorative element */}
        <div className="absolute top-3 left-3 w-3 h-3 bg-[#76ff03] rounded-full shadow-lg shadow-[#76ff03]/50" />
        
        <div className="flex items-center p-3 gap-3">
          {/* Pokemon image - compact */}
          <div className="bg-gradient-to-br from-green-100/50 to-emerald-200/50 p-2 rounded-2xl border-2 border-white/40 flex-shrink-0 relative">
            <img
              src={pokemon.image}
              alt={pokemon.name}
              className="w-16 h-16 object-contain drop-shadow-xl pointer-events-none"
            />
            {/* Pokemon number badge */}
            <div className="absolute -top-1 -right-1 bg-green-900/80 backdrop-blur-sm px-1.5 py-0.5 rounded-md border border-[#76ff03]/50">
              <span 
                className="text-[#76ff03] text-[0.6rem]"
                style={{ fontFamily: "'Press Start 2P', cursive" }}
              >
                {pokemon.number}
              </span>
            </div>
          </div>
          
          {/* Pokemon info - horizontal layout */}
          <div className="flex-1 min-w-0 flex items-center gap-3">
            <div className="flex-1 min-w-0">
              <h3 className="text-base text-green-900 mb-1.5 truncate font-medium">{pokemon.name}</h3>
              
              {/* Types - smaller */}
              <div className="flex gap-1 flex-wrap mb-2">
                {pokemon.types.map((type: string) => (
                  <span
                    key={type}
                    className="px-2 py-0.5 bg-white/60 backdrop-blur-sm text-green-800 rounded-lg text-[0.65rem] font-medium border border-white/80"
                  >
                    {type}
                  </span>
                ))}
              </div>
            </div>

            {/* Mini Stats - compact horizontal */}
            <div className="flex gap-1.5">
              <div className="bg-red-900/30 backdrop-blur-sm rounded-lg px-1.5 py-1 border border-red-500/30 text-center min-w-[2.5rem]">
                <div className="text-[#ff1744] text-xs leading-none" style={{ fontFamily: "'Press Start 2P', cursive" }}>{pokemon.stats.hp}</div>
                <div className="text-white/70 text-[0.6rem] leading-tight mt-0.5">HP</div>
              </div>
              <div className="bg-orange-900/30 backdrop-blur-sm rounded-lg px-1.5 py-1 border border-orange-500/30 text-center min-w-[2.5rem]">
                <div className="text-[#ffa726] text-xs leading-none" style={{ fontFamily: "'Press Start 2P', cursive" }}>{pokemon.stats.attack}</div>
                <div className="text-white/70 text-[0.6rem] leading-tight mt-0.5">ATK</div>
              </div>
              <div className="bg-yellow-900/30 backdrop-blur-sm rounded-lg px-1.5 py-1 border border-yellow-400/30 text-center min-w-[2.5rem]">
                <div className="text-[#ffea00] text-xs leading-none" style={{ fontFamily: "'Press Start 2P', cursive" }}>{pokemon.stats.defense}</div>
                <div className="text-white/70 text-[0.6rem] leading-tight mt-0.5">DEF</div>
              </div>
            </div>
          </div>
        </div>

        {/* View Details Link - thinner */}
        <Link
          to={`/pokemon/${pokemon.id}`}
          className="block bg-gradient-to-r from-emerald-500/80 to-green-600/80 backdrop-blur-sm hover:from-emerald-600 hover:to-green-700 text-white text-center py-2 transition-all border-t-2 border-white/30 text-sm"
        >
          View Details
        </Link>
      </div>
    </div>
  );
}
