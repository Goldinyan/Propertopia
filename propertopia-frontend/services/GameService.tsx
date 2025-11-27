import axios from "axios";

export async function getGameState() {
  const response = await axios.get("http://localhost:8080/game/state");
  return response.data; // IST JSON
}

export async function rollDice(playerName: string) {
  const response = await axios.post("http://localhost:8080/game/roll", null, {
    params: { playerName }
  });
  return response.data;
}