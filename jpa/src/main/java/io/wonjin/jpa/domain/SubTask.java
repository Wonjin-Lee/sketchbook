package io.wonjin.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class SubTask {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long subTaskId;

    private String subTaskName;
}
