package com.chronoclash.model.cards;

public abstract class Card {
    protected  String name;
    protected String description;
    protected int cost;
    protected CardType type;

    public Card(String name, String description, int cost, CardType type) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.type = type;
    }

    public abstract void execute(com.chronoclash.game.GameState gameState, int targetTurn);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }
}
