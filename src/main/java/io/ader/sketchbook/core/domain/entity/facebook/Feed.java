package io.ader.sketchbook.core.domain.entity.facebook;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feed {
    @Id
    private Long id;
    private String content;
}
