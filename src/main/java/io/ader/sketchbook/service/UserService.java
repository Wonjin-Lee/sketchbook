package io.ader.sketchbook.service;

import io.ader.sketchbook.domain.alpha.AlphaUser;
import io.ader.sketchbook.domain.beta.BetaUser;
import io.ader.sketchbook.domain.route.DataSourceRouter;
import io.ader.sketchbook.repository.CommonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final Map<String, CommonRepository> repositories;
    public void addUser(DataSourceRouter router, String name, String email) {
        AlphaUser alphaUser = new AlphaUser();
        alphaUser.setName(name);
        alphaUser.setEmail(email);

        BetaUser betaUser = new BetaUser();
        betaUser.setName(name);
        betaUser.setEmail(email);

        switch (router) {
            case ALPHA_DEV:
                log.info("This is Alpha-Dev");
                repositories.get("alphaUserDevRepository").save(alphaUser);
                break;
            case ALPHA_TEST:
                log.info("This is Alpha-Test");
                repositories.get("alphaUserTestRepository").save(alphaUser);
                break;
            case BETA_DEV:
                log.info("This is Beta-Dev");
                repositories.get("betaUserDevRepository").save(betaUser);
                break;
            case BETA_TEST:
                log.info("This is Beta-Test");
                repositories.get("betaUserTestRepository").save(betaUser);
                break;
        }
    }
}
