package com.chronoclash.game;

import com.chronoclash.model.cards.Card;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Timeline {
    private List<TurnSnapshot> history = new ArrayList<>();
    private Map<Integer, List<Card>> scheduledEffects = new HashMap<>();
    private int currentTurn = 0;
    
    public Timeline() {
        // Initialize with turn 0
        history.add(new TurnSnapshot(0));
    }

    public void rewriteHistory(int turnNumber, Card change) {
        // This is where past cards modify previous turns
        if (turnNumber >= 0 && turnNumber < history.size()) {
            TurnSnapshot snapshot = history.get(turnNumber);
            snapshot.addCard(change);
            snapshot.setModified(true);
            // Recalculate everything from that point forward would happen here
        }
    }
    
    public void modifyTurn(int turnNumber, Card card) {
        ensureTurnExists(turnNumber);
        TurnSnapshot snapshot = history.get(turnNumber);
        snapshot.addCard(card);
        snapshot.setModified(true);
    }
    
    public void applyToCurrentTurn(Card card) {
        ensureTurnExists(currentTurn);
        TurnSnapshot snapshot = history.get(currentTurn);
        snapshot.addCard(card);
    }
    
    public void scheduleEffect(int targetTurn, Card card) {
        scheduledEffects.computeIfAbsent(targetTurn, k -> new ArrayList<>()).add(card);
    }
    
    public void processTurn(int turnNumber) {
        ensureTurnExists(turnNumber);
        currentTurn = turnNumber;
        
        // Process any scheduled effects for this turn
        List<Card> effects = scheduledEffects.get(turnNumber);
        if (effects != null) {
            TurnSnapshot snapshot = history.get(turnNumber);
            for (Card card : effects) {
                snapshot.addCard(card);
            }
            scheduledEffects.remove(turnNumber);
        }
    }
    
    public void recalculateFromTurn(int fromTurn, GameState gameState) {
        // Recalculate all turns from the specified turn forward
        for (int i = fromTurn; i < history.size(); i++) {
            TurnSnapshot snapshot = history.get(i);
            for (Card card : snapshot.getCardsPlayed()) {
                card.execute(gameState, i);
            }
        }
    }
    
    private void ensureTurnExists(int turnNumber) {
        while (history.size() <= turnNumber) {
            history.add(new TurnSnapshot(history.size()));
        }
    }
    
    public TurnSnapshot getTurnSnapshot(int turnNumber) {
        if (turnNumber >= 0 && turnNumber < history.size()) {
            return history.get(turnNumber);
        }
        return null;
    }
    
    public List<TurnSnapshot> getHistory() {
        return new ArrayList<>(history);
    }
    
    public int getCurrentTurn() {
        return currentTurn;
    }
}
