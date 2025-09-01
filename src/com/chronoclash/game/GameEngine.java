package com.chronoclash.game;

import com.chronoclash.model.Player;
import com.chronoclash.model.cards.Card;

public class GameEngine {
    private Timeline timeline;
    private GameState gameState;
    private Player player1, player2;
    private Player currentPlayer;
    private int currentTurn = 0;
    
    public GameEngine() {
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.currentPlayer = player1;
        this.timeline = new Timeline();
        this.gameState = new GameState(timeline, player1, player2);
    }

    public void playCard(Card card) {
        if (currentPlayer.canPlayCard(card)) {
            int targetTurn = currentTurn + card.getType().getTurnOffset();
            currentPlayer.playCard(card);
            
            if (targetTurn < currentTurn) {
                // Past: Modify history and ripple forward
                timeline.modifyTurn(targetTurn, card);
                recalculateFromTurn(targetTurn);
            } else if (targetTurn == currentTurn) {
                // Present: Execute immediately
                timeline.applyToCurrentTurn(card);
                card.execute(gameState, targetTurn);
            } else {
                // Future: Schedule for later
                timeline.scheduleEffect(targetTurn, card);
            }
        }
    }
    
    public void nextTurn() {
        currentTurn++;
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        currentPlayer.startTurn();
        timeline.processTurn(currentTurn);
    }
    
    public boolean isGameOver() {
        return !player1.isAlive() || !player2.isAlive();
    }
    
    public Player getWinner() {
        if (player1.isAlive() && !player2.isAlive()) return player1;
        if (player2.isAlive() && !player1.isAlive()) return player2;
        return null;
    }
    
    private void recalculateFromTurn(int fromTurn) {
        timeline.recalculateFromTurn(fromTurn, gameState);
    }
    
    public int getCurrentTurn() {
        return currentTurn;
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public GameState getGameState() {
        return gameState;
    }
}
