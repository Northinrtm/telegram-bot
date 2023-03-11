package pro.sky.telegrambot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.entity.Task;
import pro.sky.telegrambot.repository.TaskRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
public class TaskServiceSheduled {
    private final TaskRepository taskRepository;

    public TaskServiceSheduled(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Scheduled(cron = "0 0/1 * * * *")
    public void run() {
        LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        System.out.println(localDateTime);
        List<Task> taskList = taskRepository.findByDateTimeEquals(localDateTime);
        for (Task t : taskList) {
            System.out.println(t);
        }
    }
}
