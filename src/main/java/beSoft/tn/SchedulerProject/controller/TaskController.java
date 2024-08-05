package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.TaskDto;
import beSoft.tn.SchedulerProject.model.Task;
import beSoft.tn.SchedulerProject.repository.TaskRepository;
import beSoft.tn.SchedulerProject.services.TaskService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }
    @PostMapping("/tasks")
    public TaskDto createTask(@RequestBody Task task) {
        return taskService.Save(task);
    }
    @GetMapping("tasks/{id}")
    public TaskDto getTask(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }
}
