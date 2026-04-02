interface TypeBadgeProps {
  type: string;
}

const typeColors: Record<string, string> = {
  Fire: "bg-gradient-to-br from-orange-500 to-red-500 shadow-lg shadow-orange-500/50",
  Water: "bg-gradient-to-br from-blue-500 to-cyan-500 shadow-lg shadow-blue-500/50",
  Grass: "bg-gradient-to-br from-green-500 to-lime-500 shadow-lg shadow-green-500/50",
  Electric: "bg-gradient-to-br from-yellow-400 to-amber-400 shadow-lg shadow-yellow-400/50",
  Psychic: "bg-gradient-to-br from-pink-500 to-purple-500 shadow-lg shadow-pink-500/50",
  Dragon: "bg-gradient-to-br from-purple-600 to-indigo-700 shadow-lg shadow-purple-600/50",
  Ghost: "bg-gradient-to-br from-indigo-600 to-violet-600 shadow-lg shadow-indigo-600/50",
  Poison: "bg-gradient-to-br from-purple-500 to-fuchsia-500 shadow-lg shadow-purple-500/50",
  Flying: "bg-gradient-to-br from-sky-400 to-blue-400 shadow-lg shadow-sky-400/50",
  Normal: "bg-gradient-to-br from-gray-400 to-slate-400 shadow-lg shadow-gray-400/50",
  Ice: "bg-gradient-to-br from-cyan-400 to-blue-300 shadow-lg shadow-cyan-400/50",
};

export function TypeBadge({ type }: TypeBadgeProps) {
  const colorClass = typeColors[type] || "bg-gradient-to-br from-gray-500 to-slate-500 shadow-lg";
  
  return (
    <span 
      className={`${colorClass} text-white px-3 py-1.5 rounded-full text-xs uppercase tracking-wider border-2 border-white/30`}
      style={{ fontFamily: "'Press Start 2P', cursive" }}
    >
      {type}
    </span>
  );
}
