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
        return gameService.rollDice(playerName);
    }
}