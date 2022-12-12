package io.wonjin.jpa.service;

import io.wonjin.jpa.domain.task.SubTask;
import io.wonjin.jpa.domain.task.Task;
import io.wonjin.jpa.domain.user.User;
import io.wonjin.jpa.repository.task.TaskRepository;
import io.wonjin.jpa.repository.user.dev.AlphaDevUserRepository;
import io.wonjin.jpa.repository.user.test.AlphaTestUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class IntegrationService {

    private final TaskRepository taskRepository;
    private final AlphaDevUserRepository alphaDevUserRepository;
    private final AlphaTestUserRepository alphaTestUserRepository;

    @Transactional("chainedTransactionManager")
    public void integration() {
        User devUser = new User();
        devUser.setName("dev-wonjin");
        alphaDevUserRepository.save(devUser);

        User testUser = new User();
        testUser.setName("test-wonjin");
        alphaTestUserRepository.save(testUser);

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
}
