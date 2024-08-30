package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.AppUserDto;
import beSoft.tn.SchedulerProject.dto.ProjectDto;
import beSoft.tn.SchedulerProject.dto.TaskDto;
import beSoft.tn.SchedulerProject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ProjectDto createProject(@RequestBody ProjectDto project) {
        return projectService.save(project);
    }

    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long id) {
        ProjectDto projectDto = projectService.findById(Math.toIntExact(id));
        if (projectDto != null) {
            return ResponseEntity.ok(projectDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
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

