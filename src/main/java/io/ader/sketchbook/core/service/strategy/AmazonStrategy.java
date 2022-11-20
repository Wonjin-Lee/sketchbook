package io.ader.sketchbook.core.service.strategy;

import io.ader.sketchbook.core.domain.Environment;
import io.ader.sketchbook.core.domain.entity.amazon.User;
import io.ader.sketchbook.core.repository.amazon.AmazonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component("AmazonStrategy")
public class AmazonStrategy implements Strategy {

    private final Map<String, AmazonRepository> repositories;

    @Override
    public void createUser(Environment environment, Map<String, String> data) {
        log.info("Amazon-Strategy Create User...");
        AmazonRepository repository = repositories.get("Amazon" + environment.name() + "UserRepo");
        User user = new User();
        user.setName(data.get("name"));
        repository.save(user);
    }

    @Override
    public void findUser(Environment environment, Map<String, String> data) {
        log.info("Amazon-Strategy Find User...");
        AmazonRepository repository = repositories.get("Amazon" + environment.name() + "UserRepo");
        Optional<User> result = repository.findById(data.get("id"));
        User user = result.orElseThrow(() -> new IllegalArgumentException("User Info does not exist..."));
        log.info("User Id : {}", user.getId());
        log.info("User Name : {}", user.getName());
    }
}
