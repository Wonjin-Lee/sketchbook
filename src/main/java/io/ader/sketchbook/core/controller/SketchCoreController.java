package io.ader.sketchbook.core.controller;

import io.ader.sketchbook.core.domain.Environment;
import io.ader.sketchbook.core.service.actor.Actor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SketchCoreController {

    private final Map<String, Actor> actorMap;

    @PostMapping("/sketchbook/core/user")
    public String createUser(@RequestBody Map<String, String> request) {
        request.forEach((key, value) -> {
            log.info("[Request Parameter] Key : {}, Value : {}", key, value);
        });

        String service = request.get("service");
        String environment = request.get("environment");

        Actor actor = actorMap.get(service + "Actor");
        actor.getStrategy().createUser(Environment.valueOf(environment), request);

        return "Success";
    }
}
