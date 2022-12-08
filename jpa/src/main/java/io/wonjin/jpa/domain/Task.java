package io.wonjin.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskId")
    private List<SubTask> subTasks;
}
