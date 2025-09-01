package com.chronoclash.model.effects;

public class ShieldEffect implements Effect {
    private final double percent;

    public ShieldEffect(double percent) {
        this.percent = percent;
    }

    @Override
    public void apply(EffectContext context){
        context.target.shield(percent);
    }

    public void canApply(EffectContext context){
        context.target.isAlive();
    }

    @Override
    public Effect copy() {
        return new ShieldEffect(percent);
    }
}
