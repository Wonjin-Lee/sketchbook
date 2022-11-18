package io.ader.sketchbook.core.domain;

public enum Environment {
    DEV("dev"),
    TEST("test"),
    PROD("prod");

    private final String type;

    Environment(String type) {
        this.type = type;
    }
}
