package com.propertopia.model;

import java.util.List;

public class Game {
    private List<Player> players;
    private List<Field> board;

    public Game(List<Player> players, List<Field> board) {
        this.players = players;
        this.board = board;
    }

    public List<Player> getPlayers() { return players; }
    public List<Field> getBoard() { return board; }

    public Player findPlayer(String name) {
        return players.stream()
                      .filter(p -> p.getName().equals(name))
                      .findFirst()
                      .orElse(null);
    }
}