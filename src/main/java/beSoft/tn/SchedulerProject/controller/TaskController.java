package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.*;
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


    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
    }

    @GetMapping("comments/{id}")
    public List<CommentDto> getTaskComments(@PathVariable Integer id) {
        return taskService.getAllCommentsByTaskId(id);
    }

    @GetMapping("dependencies/{id}")
    public List<DependencyDto> getTaskDependencies(@PathVariable Integer id) {
        return taskService.getAllDependenciesByTaskId(id);
    }

    @GetMapping("activities/{id}")
    public List<ActivityDto> getTaskActivities(@PathVariable Integer id) {
        return taskService.getAllActivitiesByTaskId(id);
    }

    @GetMapping("user/{id}")
    public AppUserDto getTaskUser(@PathVariable Integer id) {
        return taskService.getUser(id);
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(@PathVariable Integer id, @RequestBody TaskDto task) {
        return taskService.update(task,id);
    }
}
