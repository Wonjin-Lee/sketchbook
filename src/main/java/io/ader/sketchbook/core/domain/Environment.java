package io.ader.sketchbook.core.domain;

import javax.swing.text.html.Option;
import java.util.Optional;

public enum Environment {
    Dev("Dev"),
    Test("Test"),
    Prod("Prod");

    private final String type;

    Environment(String type) {
        this.type = type;
    }
}
