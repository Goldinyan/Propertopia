package com.propertopia.controller;

import com.propertopia.model.Game;
import com.propertopia.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/state")
    public Game getState() {
        return gameService.getGameState();
    }

    @PostMapping("/roll")
    public Game rollDice(@RequestParam String playerName) {
        if(gameService.getGameState().findPlayer(playerName) != null){
            return gameService.rollDice(playerName);
        }
        throw new IllegalArgumentException("Player not found: " + playerName);
    }
}