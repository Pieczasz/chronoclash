import com.chronoclash.game.GameEngine;

public class Main {
    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        
        System.out.println("=== ChronoClash Game Demo ===");
        System.out.println("Current Turn: " + engine.getCurrentTurn());
        System.out.println("Current Player: " + engine.getCurrentPlayer().getName());
        System.out.println("Player 1 Health: " + engine.getGameState().getPlayer1().getHealth());
        System.out.println("Player 2 Health: " + engine.getGameState().getPlayer2().getHealth());
        
        System.out.println("\nGame initialized successfully!");
        System.out.println("Players are ready to play cards that can affect past, present, and future turns.");
    }
}