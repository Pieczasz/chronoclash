package com.chronoclash.model.effects;

public interface Effect {
    void apply(EffectContext context);
    boolean canApply(EffectContext context);
    Effect copy();
}
