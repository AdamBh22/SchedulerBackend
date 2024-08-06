package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.ProjectDto;
import beSoft.tn.SchedulerProject.model.Project;
import beSoft.tn.SchedulerProject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping
    public ProjectDto saveProject(@RequestBody ProjectDto project) {
        return projectService.save(project);
    }
    @GetMapping
    public List<ProjectDto> getAllProjects() {
        return projectService.findAll();
    }
    @GetMapping("/{id}")
    public ProjectDto getProject(@PathVariable Integer id) {
        return projectService.findById(id);
    }
}
