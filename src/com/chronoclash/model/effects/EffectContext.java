package com.chronoclash.model.effects;

import com.chronoclash.game.GameState;
import com.chronoclash.game.Timeline;
import com.chronoclash.model.Player;
import java.util.Map;

public class EffectContext {
    public final GameState gameState;
    public final Timeline timeline;
    public final Player source;
    public final Player target;
    public final int targetTurn;
    public final Map<String, Object> metadata;

    public EffectContext(GameState gameState, Timeline timeline, Player source, Player target, int targetTurn, Map<String, Object> metadata) {
        this.gameState = gameState;
        this.timeline = timeline;
        this.source = source;
        this.target = target;
        this.targetTurn = targetTurn;
        this.metadata = metadata;
    }
}
