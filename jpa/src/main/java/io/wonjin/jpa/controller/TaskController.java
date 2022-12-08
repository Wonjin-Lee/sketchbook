package io.wonjin.jpa.controller;

import io.wonjin.jpa.domain.Task;
import io.wonjin.jpa.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @PostMapping(value = "/sketchbook/api/v1/task")
    public String acceptTask() {
        taskService.addTask();

        return "Success";
    }

    @GetMapping(value = "/sketchbook/api/v1/task")
    public String searchTask(@RequestBody Map<String, Object> requestBody) {
        Long taskId = Long.parseLong((String) requestBody.get("taskId"));
        Task task = taskService.findTask(taskId).orElseThrow(() -> new IllegalArgumentException("TaskId does not exist."));

        log.info("TaskId : {}, TaskName : {}", task.getTaskId(), task.getTaskName());
        task.getSubTasks().forEach(subTask -> {
            log.info("SubTaskId : {}, SubTaskName : {}", subTask.getSubTaskId(), subTask.getSubTaskName());
        });

        return "Success";
    }
}
