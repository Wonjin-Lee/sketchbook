package io.wonjin.jpa.repository.task;

import io.wonjin.jpa.domain.task.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
