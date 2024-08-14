package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.AppUserDto;
import beSoft.tn.SchedulerProject.dto.ProjectDto;
import beSoft.tn.SchedulerProject.dto.TaskDto;
import beSoft.tn.SchedulerProject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping
    public ProjectDto saveProject(@RequestBody ProjectDto project) {
        ProjectDto result = projectService.save(project);
        return result;
    }
    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.findAll();
    }
    @GetMapping("/{id}")
    public ProjectDto getProject(@PathVariable Integer id) {
        return projectService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Integer id) {
        projectService.delete(id);
    }

    @GetMapping("/tasks/{id}")
    public List<TaskDto> getTasks(@PathVariable Integer id) {
        return projectService.findTasksById(id);
    }

    @GetMapping("/usersByProject/{id}")
    public List<AppUserDto> getUsers(@PathVariable Integer id) {
        return projectService.findUsersByProjectId(id);
    }
    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable Integer id, @RequestBody ProjectDto project) {
        return projectService.update(project, id);
    }
}
