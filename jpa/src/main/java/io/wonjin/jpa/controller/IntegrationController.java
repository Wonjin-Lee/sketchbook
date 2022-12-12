package io.wonjin.jpa.controller;

import io.wonjin.jpa.service.IntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class IntegrationController {
    private final IntegrationService integrationService;

    @GetMapping("/sketchbook/api/v1/integration")
    public String integration() {
        integrationService.integration();
        return "Success";
    }
}
