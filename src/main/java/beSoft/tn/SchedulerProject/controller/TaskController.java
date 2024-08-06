package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.TaskDto;
import beSoft.tn.SchedulerProject.model.Task;
import beSoft.tn.SchedulerProject.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;
    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }
    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto task) {
        return taskService.Save(task);
    }
    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }
}
