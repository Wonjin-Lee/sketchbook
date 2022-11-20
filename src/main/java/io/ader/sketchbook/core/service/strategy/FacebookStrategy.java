package io.ader.sketchbook.core.service.strategy;

import io.ader.sketchbook.core.domain.Environment;
import io.ader.sketchbook.core.domain.entity.facebook.User;
import io.ader.sketchbook.core.repository.facebook.FacebookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component("FacebookStrategy")
public class FacebookStrategy implements Strategy {
    private final Map<String, FacebookRepository> repositories;

    @Override
    public void createUser(Environment environment, Map<String, String> data) {
        log.info("Facebook-Strategy Create User...");
        FacebookRepository repository = repositories.get("Facebook" + environment.name() + "UserRepo");
        User user = new User();
        user.setName(data.get("name"));
        repository.save(user);
    }

    @Override
    public void findUser(Environment environment, Map<String, String> data) {
        log.info("Facebook-Strategy Find User...");
        FacebookRepository repository = repositories.get("Amazon" + environment.name() + "UserRepo");
        Optional<User> result = repository.findById(data.get("id"));
        User user = result.orElseThrow(() -> new IllegalArgumentException("User Info does not exist..."));
        log.info("User Id : {}", user.getId());
        log.info("User Name : {}", user.getName());
    }
}
