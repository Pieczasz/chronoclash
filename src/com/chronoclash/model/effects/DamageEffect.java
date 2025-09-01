package com.chronoclash.model.effects;

public class DamageEffect implements Effect {
    private final int damage;

    public DamageEffect(int damage) {
        this.damage = damage;
    }

    @Override
    public void apply(EffectContext context) {
        context.target.takeDamage(damage);
    }

    @Override
    public boolean canApply(EffectContext context) {
        return context.target.isAlive();
    }

    @Override
    public Effect copy() {
        return new DamageEffect(damage);
    }
}