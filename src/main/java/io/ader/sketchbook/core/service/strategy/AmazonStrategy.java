package io.ader.sketchbook.core.service.strategy;

import io.ader.sketchbook.core.domain.Environment;
import io.ader.sketchbook.core.repository.amazon.AmazonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component("AmazonStrategy")
public class AmazonStrategy implements Strategy {

    private final Map<String, AmazonRepository> repositoryMap;

    @Override
    public void createUser(Environment environment, Map<String, String> data) {
        
    }

    @Override
    public void findUser(Environment environment, Map<String, String> data) {

    }
}
