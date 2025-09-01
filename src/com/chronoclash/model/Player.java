package com.chronoclash.model;

import com.chronoclash.model.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int MAX_HEALTH = 100;
    private static final int MAX_HAND_SIZE = 7;
    private static final int STARTING_HAND_SIZE = 3;
    
    private String name;
    private int health = MAX_HEALTH;
    private int maxHealth = MAX_HEALTH;
    private int mana = 0;
    private int maxMana = 0;
    private double shield = 0.0;
    private double damageMultiplier = 1.0;
    private List<Card> deck = new ArrayList<>();
    private List<Card> hand = new ArrayList<>();
    private List<Card> graveyard = new ArrayList<>();
    
    public Player(String name) {
        this.name = name;
    }
    
    public void startTurn() {
        maxMana++;
        mana = maxMana;
        drawCard();
    }
    
    public void drawCard() {
        if (!deck.isEmpty() && hand.size() < MAX_HAND_SIZE) {
            Card card = deck.remove(0);
            hand.add(card);
        }
    }
    
    public boolean canPlayCard(Card card) {
        return hand.contains(card) && mana >= card.getCost();
    }
    
    public void playCard(Card card) {
        if (canPlayCard(card)) {
            hand.remove(card);
            mana -= card.getCost();
            graveyard.add(card);
        }
    }
    
    public void takeDamage(int damage) {
        int actualDamage = (int) (damage * damageMultiplier);
        int shieldedDamage = (int) (actualDamage * (1.0 - shield));
        health = Math.max(0, health - shieldedDamage);
        
        // Shield degrades after absorbing damage
        shield = Math.max(0.0, shield - 0.1);
    }
    
    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }
    
    public void shield(double shieldAmount) {
        shield = Math.min(1.0, shield + shieldAmount);
    }
    
    public void multiplyDamage(double multiplier) {
        damageMultiplier *= multiplier;
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(maxHealth, health));
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public int getMana() {
        return mana;
    }
    
    public void setMana(int mana) {
        this.mana = Math.max(0, mana);
    }
    
    public int getMaxMana() {
        return maxMana;
    }
    
    public double getShield() {
        return shield;
    }
    
    public void setShield(double shield) {
        this.shield = Math.max(0.0, Math.min(1.0, shield));
    }
    
    public double getDamageMultiplier() {
        return damageMultiplier;
    }
    
    public void setDamageMultiplier(double multiplier) {
        this.damageMultiplier = Math.max(0.1, multiplier);
    }
    
    public List<Card> getDeck() {
        return new ArrayList<>(deck);
    }
    
    public void setDeck(List<Card> deck) {
        this.deck = new ArrayList<>(deck);
    }
    
    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }
    
    public List<Card> getGraveyard() {
        return new ArrayList<>(graveyard);
    }
}
