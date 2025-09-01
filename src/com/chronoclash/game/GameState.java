package com.chronoclash.game;

import com.chronoclash.model.Player;

public class GameState {
    private Timeline timeline;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player targetPlayer;
    
    public GameState(Timeline timeline, Player player1, Player player2) {
        this.timeline = timeline;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.targetPlayer = player2;
    }
    
    public Timeline getTimeline() {
        return timeline;
    }
    
    public Player getPlayer1() {
        return player1;
    }
    
    public Player getPlayer2() {
        return player2;
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }
    
    public Player getTargetPlayer() {
        return targetPlayer;
    }
    
    public void setTargetPlayer(Player player) {
        this.targetPlayer = player;
    }
    
    public Player getOpponent(Player player) {
        return (player == player1) ? player2 : player1;
    }
    
    public void switchPlayers() {
        Player temp = currentPlayer;
        currentPlayer = targetPlayer;
        targetPlayer = temp;
    }
}
