package com.chronoclash.model.effects;

public class DamageMultiplierEffect implements Effect {
    private final double damageMultiplier;

    public DamageMultiplierEffect(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    @Override
    public void apply(EffectContext context){
        context.target.multiplyDamage(damageMultiplier);
    }

    @Override
    public void canApply(EffectContext context){
        context.target.isAlive();
    }

    @Override
    public Effect copy() {
        return new DamageMultiplierEffect(damageMultiplier);
    }
}
