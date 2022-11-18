package io.ader.sketchbook.core.domain;

public enum Service {
    AMAZON("amazon"),
    FACEBOOK("facebook"),
    GOOGLE("google");

    private final String name;

    Service(String name) {
        this.name = name;
    }
}
