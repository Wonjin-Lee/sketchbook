package io.wonjin.jpa.service;

import io.wonjin.jpa.domain.SubTask;
import io.wonjin.jpa.domain.Task;
import io.wonjin.jpa.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public void addTask() {
        Task task = new Task();
        task.setTaskName("First Task");

        SubTask subTask1 = new SubTask();
        subTask1.setSubTaskName("First SubTask");

        SubTask subTask2 = new SubTask();
        subTask2.setSubTaskName("Second SubTask");

        SubTask subTask3 = new SubTask();
        subTask3.setSubTaskName("Third SubTask");

        task.setSubTasks(Arrays.asList(new SubTask[]{subTask1, subTask2, subTask3}));

        taskRepository.save(task);
    }

    public Optional<Task> findTask(Long taskId) {
        return taskRepository.findById(taskId);
    }
}
