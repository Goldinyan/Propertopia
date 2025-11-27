package com.propertopia.service;

import com.propertopia.model.Field;
import com.propertopia.model.Game;
import com.propertopia.model.Player;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class GameService {
    private Game game;

    public GameService() {
        //BEISPIEL 
        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");
        Field f1 = new Field("Bahnhof", 200);
        Field f2 = new Field("Parkstraße", 350);

        game = new Game(Arrays.asList(p1, p2), Arrays.asList(f1, f2));
    }

    public Game getGameState() {
        return game;
    }

    public Game rollDice(String playerName) {
        Player player = game.findPlayer(playerName);
        int dice = (int)(Math.random() * 6) + 1;
        player.move(dice);
        return game;
    }
}