package io.ader.sketchbook.core.controller;

import io.ader.sketchbook.core.domain.Environment;
import io.ader.sketchbook.core.service.actor.Actor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class SketchController {

    private final Map<String, Actor> actorMap;

    @PostMapping("/sketchbook/core/user")
    public String createUser(@RequestBody Map<String, String> request) {

        Map<String, String> data = null;

        String service = request.get("service");
        String environment = request.get("environment");

        Actor actor = actorMap.get(service);

        actor.getStrategy().createUser(Environment.valueOf(environment), data);

        return "Success";
    }
}
