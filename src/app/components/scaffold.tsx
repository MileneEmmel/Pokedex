import { ReactNode } from "react";
import { useLocation, useNavigate } from "react-router";
import { BookOpen, Shield, ArrowLeft } from "lucide-react";

interface ScaffoldProps {
  children: ReactNode;
  title: string;
  showBack?: boolean;
}

export function Scaffold({ children, title, showBack }: ScaffoldProps) {
  const location = useLocation();
  const navigate = useNavigate();
  
  // Don't show bottom bar on home and detail pages
  const showBottomBar = location.pathname === "/pokedex" || location.pathname === "/team";
  const isPokedex = location.pathname === "/pokedex";
  const isTeam = location.pathname === "/team";

  return (
    <div className="min-h-screen bg-gradient-to-br from-lime-100 via-green-100 to-emerald-200 flex flex-col">
      {/* Top Bar */}
      <div className="sticky top-0 z-50 bg-white/30 backdrop-blur-lg border-b-3 border-white/50 shadow-lg">
        <div className="container mx-auto px-4 py-4 max-w-md">
          <div className="flex items-center justify-between">
            {showBack ? (
              <button
                onClick={() => navigate(-1)}
                className="bg-white/60 backdrop-blur-sm p-2.5 rounded-xl border-2 border-white/60 hover:bg-white/80 transition-all shadow-md"
              >
                <ArrowLeft className="w-5 h-5 text-green-800" />
              </button>
            ) : (
              <div className="w-10" /> // Spacer
            )}
            
            <h1 
              className="text-xl text-green-900 tracking-tight text-center flex-1"
              style={{ fontFamily: "'Press Start 2P', cursive" }}
            >
              {title}
            </h1>
            
            <div className="w-10" /> {/* Spacer for centering */}
          </div>
        </div>
      </div>

      {/* Content */}
      <div className="flex-1 overflow-y-auto pb-20">
        {children}
      </div>

      {/* Bottom Navigation Bar */}
      {showBottomBar && (
        <div className="fixed bottom-0 left-0 right-0 z-50 bg-white/30 backdrop-blur-lg border-t-3 border-white/50 shadow-2xl">
          <div className="container mx-auto px-4 max-w-md">
            <div className="grid grid-cols-2 gap-4 py-4">
              {/* Pokédex Button */}
              <button
                onClick={() => navigate("/pokedex")}
                className={`flex flex-col items-center gap-2 py-3 rounded-2xl transition-all border-3 ${
                  isPokedex
                    ? "bg-gradient-to-br from-emerald-500 to-green-600 border-white/50 shadow-lg shadow-emerald-500/30 scale-105"
                    : "bg-white/40 border-white/60 hover:bg-white/60"
                }`}
              >
                <BookOpen className={`w-6 h-6 ${isPokedex ? "text-white" : "text-green-800"}`} strokeWidth={2.5} />
                <span 
                  className={`text-xs ${isPokedex ? "text-white" : "text-green-800"}`}
                  style={{ fontFamily: "'Press Start 2P', cursive" }}
                >
                  POKÉDEX
                </span>
              </button>

              {/* Team Button */}
              <button
                onClick={() => navigate("/team")}
                className={`flex flex-col items-center gap-2 py-3 rounded-2xl transition-all border-3 ${
                  isTeam
                    ? "bg-gradient-to-br from-teal-500 to-cyan-600 border-white/50 shadow-lg shadow-teal-500/30 scale-105"
                    : "bg-white/40 border-white/60 hover:bg-white/60"
                }`}
              >
                <Shield className={`w-6 h-6 ${isTeam ? "text-white" : "text-green-800"}`} strokeWidth={2.5} />
                <span 
                  className={`text-xs ${isTeam ? "text-white" : "text-green-800"}`}
                  style={{ fontFamily: "'Press Start 2P', cursive" }}
                >
                  MY TEAM
                </span>
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}