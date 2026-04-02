import { Link } from "react-router";
import { Users, Zap, Leaf } from "lucide-react";

export function Home() {
  return (
    <div className="min-h-screen bg-gradient-to-br from-emerald-400 via-green-500 to-teal-600 relative overflow-hidden">
      {/* Decorative organic elements */}
      <div className="absolute top-10 left-10 w-32 h-32 bg-lime-400/20 rounded-full blur-3xl" />
      <div className="absolute bottom-20 right-20 w-40 h-40 bg-emerald-300/20 rounded-full blur-3xl" />
      <div className="absolute top-1/3 right-10 w-24 h-24 bg-green-300/20 rounded-full blur-2xl" />
      
      {/* Leaf decorations */}
      <div className="absolute top-20 right-1/4 opacity-10">
        <Leaf className="w-24 h-24 text-white rotate-45" />
      </div>
      <div className="absolute bottom-32 left-1/4 opacity-10">
        <Leaf className="w-32 h-32 text-white -rotate-12" />
      </div>

      <div className="container mx-auto px-4 py-8 sm:py-12 relative z-10 max-w-md">
        {/* Header */}
        <div className="text-center mb-8 sm:mb-12">
          <div className="flex items-center justify-center mb-6">
            {/* Pokéball icon style */}
            <div className="relative">
              <div className="bg-white/20 backdrop-blur-md p-6 rounded-full border-4 border-white/40 shadow-2xl">
                <div className="w-16 h-16 rounded-full bg-gradient-to-b from-red-500 to-white relative overflow-hidden border-4 border-gray-800">
                  {/* Top red half */}
                  <div className="absolute inset-0 bg-gradient-to-b from-red-500 via-red-600 to-red-700 h-1/2" />
                  {/* Bottom white half */}
                  <div className="absolute bottom-0 inset-x-0 bg-gradient-to-b from-gray-100 to-white h-1/2" />
                  {/* Middle black stripe */}
                  <div className="absolute top-1/2 left-0 right-0 h-1 bg-gray-900 transform -translate-y-1/2" />
                  {/* Center button */}
                  <div className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 w-5 h-5 bg-white rounded-full border-3 border-gray-900 shadow-inner">
                    <div className="absolute inset-1 bg-gradient-to-br from-gray-200 to-gray-100 rounded-full" />
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          <h1 
            className="text-4xl sm:text-5xl text-white drop-shadow-2xl mb-3 tracking-tight"
            style={{ fontFamily: "'Press Start 2P', cursive" }}
          >
            POKÉDEX
          </h1>
          <p className="text-lg text-white/90 drop-shadow-lg px-4">
            Capture, Discover, Build Your Dream Team!
          </p>
          
          {/* Retro Game Display */}
          <div className="mt-8 bg-white/20 backdrop-blur-md border-4 border-white/40 rounded-2xl p-4 shadow-2xl">
            <div className="bg-green-900/50 rounded-xl p-3 border-2 border-green-700/50">
              <div className="grid grid-cols-3 gap-2 text-center">
                <div>
                  <div className="text-[#76ff03] text-2xl mb-1" style={{ fontFamily: "'Press Start 2P', cursive" }}>18</div>
                  <div className="text-white text-xs">Pokémon</div>
                </div>
                <div>
                  <div className="text-[#ffea00] text-2xl mb-1" style={{ fontFamily: "'Press Start 2P', cursive" }}>11</div>
                  <div className="text-white text-xs">Types</div>
                </div>
                <div>
                  <div className="text-[#00e5ff] text-2xl mb-1" style={{ fontFamily: "'Press Start 2P', cursive" }}>6</div>
                  <div className="text-white text-xs">Max Team</div>
                </div>
              </div>
            </div>
          </div>
        </div>

        {/* Quick Access Buttons - Glassmorphism Cards */}
        <div className="space-y-4">
          {/* Pokedex Card */}
          <Link
            to="/pokedex"
            className="group block"
          >
            <div className="bg-white/25 backdrop-blur-lg border-3 border-white/40 rounded-3xl p-6 shadow-2xl hover:shadow-[0_0_40px_rgba(118,255,3,0.4)] transition-all duration-300 hover:scale-[1.02] hover:bg-white/30 relative overflow-hidden">
              {/* Decorative corner accent */}
              <div className="absolute top-0 right-0 w-20 h-20 bg-[#76ff03]/20 rounded-bl-full" />
              
              <div className="flex items-center gap-4">
                <div className="bg-gradient-to-br from-emerald-500 to-green-600 w-16 h-16 rounded-2xl flex items-center justify-center shadow-lg border-3 border-white/50 group-hover:scale-110 transition-transform relative">
                  <Zap className="w-9 h-9 text-[#ffea00] fill-[#ffea00]" />
                </div>
                <div className="flex-1">
                  <h2 className="text-2xl text-white mb-1 drop-shadow-lg">Pokédex</h2>
                  <p className="text-white/80 text-sm">
                    Explore all available Pokémon
                  </p>
                </div>
              </div>
            </div>
          </Link>

          {/* Team Builder Card */}
          <Link
            to="/team"
            className="group block"
          >
            <div className="bg-white/25 backdrop-blur-lg border-3 border-white/40 rounded-3xl p-6 shadow-2xl hover:shadow-[0_0_40px_rgba(255,234,0,0.4)] transition-all duration-300 hover:scale-[1.02] hover:bg-white/30 relative overflow-hidden">
              {/* Decorative corner accent */}
              <div className="absolute top-0 right-0 w-20 h-20 bg-[#ffea00]/20 rounded-bl-full" />
              
              <div className="flex items-center gap-4">
                <div className="bg-gradient-to-br from-teal-500 to-cyan-600 w-16 h-16 rounded-2xl flex items-center justify-center shadow-lg border-3 border-white/50 group-hover:scale-110 transition-transform">
                  <Users className="w-9 h-9 text-white" strokeWidth={2.5} />
                </div>
                <div className="flex-1">
                  <h2 className="text-2xl text-white mb-1 drop-shadow-lg">My Team</h2>
                  <p className="text-white/80 text-sm">
                    Manage your battle squad
                  </p>
                </div>
              </div>
            </div>
          </Link>
        </div>

        {/* Bottom decoration */}
        <div className="mt-8 text-center">
          <div className="inline-flex items-center gap-2 bg-white/20 backdrop-blur-md px-4 py-2 rounded-full border-2 border-white/30">
            <div className="w-2 h-2 bg-[#76ff03] rounded-full animate-pulse shadow-lg shadow-[#76ff03]/50" />
            <span className="text-white text-sm">Ready to catch 'em all?</span>
          </div>
        </div>
      </div>
    </div>
  );
}
