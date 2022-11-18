package io.ader.sketchbook.core.service.actor;

import io.ader.sketchbook.core.service.strategy.Strategy;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Actor {
    protected Strategy strategy;

    protected void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
