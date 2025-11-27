"use client"

import React, { useEffect, useState } from "react";
import { getGameState } from "../../services/GameService";
import { rollDice } from "../../services/GameService";

export default function MainView() {
  const [game, setGame] = useState<any>(null);

  useEffect(() => {
    getGameState().then((data) => setGame(data));
  }, []);

  return (
    <div>
      <h1>Game State</h1>
      {game &&
        game.players.map((p: any) => (
          <p key={p.name}>
            {p.name} hat {p.money}€ und steht auf Feld {p.position}
          </p>
        ))}
      <button onClick={() => rollDice("Alice").then((data) => setGame(data))}>
        Würfeln für Alice
      </button>
    </div>
  );
}
