package io.wonjin.jpa.domain.task;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Task {
    @Column(name = "task_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(name = "task_name")
    private String taskName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<SubTask> subTasks;
}
