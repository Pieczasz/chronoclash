package com.chronoclash.model.cards;

public enum CardType {
    DEEP_PAST(-2),   // Affects 2 turns ago
    PAST(-1),        // Affects 1 turn ago
    PRESENT(0),      // Affects current turn
    FUTURE(1),       // Triggers next turn
    FAR_FUTURE(2);   // Triggers in 2 turns

    private final int turnOffset;

    CardType(int turnOffset) {
        this.turnOffset = turnOffset;
    }

    public int getTurnOffset() {
        return turnOffset;
    }

    public boolean canAffectTurn(int currentTurn, int targetTurn) {
        return targetTurn == currentTurn + turnOffset;
    }
}
