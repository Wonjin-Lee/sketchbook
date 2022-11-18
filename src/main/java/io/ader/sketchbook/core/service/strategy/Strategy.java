package io.ader.sketchbook.core.service.strategy;

import io.ader.sketchbook.core.domain.Environment;
import io.ader.sketchbook.core.repository.CommonRepository;

import java.util.Map;

public interface Strategy {
    void createUser(Environment environment, Map<String, String> data);
    void findUser(Environment environment, Map<String, String> data);
}
