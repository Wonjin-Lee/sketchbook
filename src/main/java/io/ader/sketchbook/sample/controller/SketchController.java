package io.ader.sketchbook.sample.controller;

import io.ader.sketchbook.sample.domain.route.DataSourceRouter;
import io.ader.sketchbook.sample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class SketchController {

    private final UserService userService;

    @PostMapping(value = "/sketchbook/user")
    public String createUser(@RequestBody Map<String, Object> request) {
        String name = (String) request.get("name");
        String email = (String) request.get("email");
        DataSourceRouter router = DataSourceRouter.valueOf((String) request.get("router"));

        userService.addUser(router, name, email);

        return "Success";
    }
}
