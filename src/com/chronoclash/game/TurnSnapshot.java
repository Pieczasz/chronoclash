package com.chronoclash.game;

import com.chronoclash.model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class TurnSnapshot {
    private final int turnNumber;
    private int player1Health;
    private int player2Health;
    private int player1Damage;
    private int player2Damage;
    private int player1Mana;
    private int player2Mana;
    private double player1Shield;
    private double player2Shield;
    private List<Card> cardsPlayed;
    private boolean isModified; // True if altered by time paradox
    
    public TurnSnapshot(int turnNumber) {
        this.turnNumber = turnNumber;
        this.player1Health = 100;
        this.player2Health = 100;
        this.player1Damage = 0;
        this.player2Damage = 0;
        this.player1Mana = turnNumber; // Mana increases each turn
        this.player2Mana = turnNumber;
        this.player1Shield = 0.0;
        this.player2Shield = 0.0;
        this.cardsPlayed = new ArrayList<>();
        this.isModified = false;
    }
    
    public void addCard(Card card) {
        cardsPlayed.add(card);
    }
    
    public List<Card> getCardsPlayed() {
        return new ArrayList<>(cardsPlayed);
    }
    
    public boolean isModified() {
        return isModified;
    }
    
    public void setModified(boolean modified) {
        isModified = modified;
    }
    
    public int getTurnNumber() {
        return turnNumber;
    }
    
    // Player 1 getters and setters
    public int getPlayer1Health() {
        return player1Health;
    }
    
    public void setPlayer1Health(int health) {
        this.player1Health = Math.max(0, health);
    }
    
    public int getPlayer1Damage() {
        return player1Damage;
    }
    
    public void setPlayer1Damage(int damage) {
        this.player1Damage = Math.max(0, damage);
    }
    
    public int getPlayer1Mana() {
        return player1Mana;
    }
    
    public void setPlayer1Mana(int mana) {
        this.player1Mana = Math.max(0, mana);
    }
    
    public double getPlayer1Shield() {
        return player1Shield;
    }
    
    public void setPlayer1Shield(double shield) {
        this.player1Shield = Math.max(0.0, Math.min(1.0, shield));
    }
    
    // Player 2 getters and setters
    public int getPlayer2Health() {
        return player2Health;
    }
    
    public void setPlayer2Health(int health) {
        this.player2Health = Math.max(0, health);
    }
    
    public int getPlayer2Damage() {
        return player2Damage;
    }
    
    public void setPlayer2Damage(int damage) {
        this.player2Damage = Math.max(0, damage);
    }
    
    public int getPlayer2Mana() {
        return player2Mana;
    }
    
    public void setPlayer2Mana(int mana) {
        this.player2Mana = Math.max(0, mana);
    }
    
    public double getPlayer2Shield() {
        return player2Shield;
    }
    
    public void setPlayer2Shield(double shield) {
        this.player2Shield = Math.max(0.0, Math.min(1.0, shield));
    }
}
