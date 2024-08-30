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

    @CrossOrigin(origins = "http://localhost:4201")
    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto task) {
        return taskService.Save(task);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }


    @CrossOrigin(origins = "http://localhost:4201")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/comments/{id}")
    public List<CommentDto> getTaskComments(@PathVariable Integer id) {
        return taskService.getAllCommentsByTaskId(id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/dependencies/{id}")
    public List<DependencyDto> getTaskDependencies(@PathVariable Integer id) {
        return taskService.getAllDependenciesByTaskId(id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/activities/{id}")
    public List<ActivityDto> getTaskActivities(@PathVariable Integer id) {
        return taskService.getAllActivitiesByTaskId(id);
    }


    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/user/{id}")
    public AppUserDto getTaskUser(@PathVariable Integer id) {
        return taskService.getUser(id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/status/{status}")
    public List<TaskDto> getAllTasksByStatus(@PathVariable String status) {
        return taskService.getAllTasksByStatus(status);
    }


    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/tasksForToday/{id}")
    public List<TaskDto> getAllTasksForToday(@PathVariable Integer id) {
        return taskService.getTasksForToday(id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @PutMapping("/{id}")
    public TaskDto updateTask(@PathVariable Integer id, @RequestBody TaskDto task) {
        return taskService.update(task,id);
    }
}
