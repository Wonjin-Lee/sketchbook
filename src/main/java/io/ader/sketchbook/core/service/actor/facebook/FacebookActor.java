package io.ader.sketchbook.core.service.actor.facebook;

import io.ader.sketchbook.core.domain.Environment;
import io.ader.sketchbook.core.service.actor.Actor;
import io.ader.sketchbook.core.service.strategy.Strategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("FacebookActor")
public class FacebookActor extends Actor {
    public FacebookActor(@Qualifier("FacebookStrategy") Strategy strategy) {
        setStrategy(strategy);
    }

    public void createUser(Environment environment, Map<String, String> data) {
        strategy.createUser(environment, data);
    }

    public void findUser(Environment environment, Map<String, String> data) {
        strategy.findUser(environment, data);
    }
}
