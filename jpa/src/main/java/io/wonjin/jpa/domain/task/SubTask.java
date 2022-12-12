package io.wonjin.jpa.domain.task;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "sub_task")
@Entity
public class SubTask {
    @Column(name = "sub_task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long subTaskId;

    @Column(name = "sub_task_name")
    private String subTaskName;
}
