package io.ader.sketchbook.core.domain;

public enum Destination {
    AMAZON_DEV(Service.AMAZON, Environment.DEV),
    AMAZON_TEST(Service.AMAZON, Environment.TEST),
    FACEBOOK_DEV(Service.FACEBOOK, Environment.DEV),
    FACEBOOK_TEST(Service.FACEBOOK, Environment.TEST),
    GOOGLE_DEV(Service.GOOGLE, Environment.DEV),
    GOOGLE_TEST(Service.GOOGLE, Environment.TEST);

    private final Service service;
    private final Environment environment;

    Destination(Service service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }
}