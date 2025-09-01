package com.chronoclash.model.effects;

public class HealEffect implements Effect {
    private final int health;

    public HealEffect(int health) {
        this.health = health;
    }

    @Override
    public void apply(EffectContext context){
        context.target.heal(health);
    }

    @Override
    public void canApply(EffectContext context){
        context.target.health !== MAX_HEALTH;
    }

    @Override
    public Effect copy() {
        return new HealEffect(health);
    }
}
