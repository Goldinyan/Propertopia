package com.propertopia.service;

import com.propertopia.model.Field;
import com.propertopia.model.Game;
import com.propertopia.model.Player;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class GameService {
    private Game game;
    private List<Player> players;

    public GameService() {
        //BEISPIEL 
        Field f1 = new Field("Bahnhof", 200, 1.4, 20, 50, "Brown");
        Field f2 = new Field("Parkstraße", 500, 1.2, 80, 100, "Red");
        game = new Game(Arrays.asList(), Arrays.asList(f1, f2));
    }

    public Game getGameState() {
        return game;
    }

    public Game rollDice(String playerName) {
        Player player = game.findPlayer(playerName);
        int dice = (int)(Math.random() * 6) + 1;
        if(player == null){
            throw new IllegalArgumentException("Player not found: " + playerName);
        }
        player.move(dice);
        return game;
    }

    public Game addPlayer(String playerName) {
        players.add(new Player(playerName));
        return game;
    }

    public Game buildHouse(String playerName, int fieldId) {
        Player player = game.findPlayer(playerName);
        var props = player.getProperties();
        var propOpt = props.stream().filter(p -> p.getId() == fieldId).findFirst();
        if(propOpt.isPresent()){
            var prop = propOpt.get();
            if(player.getMoney() >= prop.getHousePrice()){
                prop.addHouse(player);
            }
        }
        return game;
    }
}