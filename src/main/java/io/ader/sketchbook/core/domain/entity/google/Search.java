package io.ader.sketchbook.core.domain.entity.google;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Search {
    @Id
    private Long id;
    private String keyword;
}
