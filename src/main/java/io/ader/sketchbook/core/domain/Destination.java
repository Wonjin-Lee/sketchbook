package io.ader.sketchbook.core.domain;

public enum Destination {
    AMAZON_DEV(Service.AMAZON, Environment.Dev),
    AMAZON_TEST(Service.AMAZON, Environment.Test),
    FACEBOOK_DEV(Service.FACEBOOK, Environment.Dev),
    FACEBOOK_TEST(Service.FACEBOOK, Environment.Test),
    GOOGLE_DEV(Service.GOOGLE, Environment.Dev),
    GOOGLE_TEST(Service.GOOGLE, Environment.Test);

    private final Service service;
    private final Environment environment;

    Destination(Service service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }
}