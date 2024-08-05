package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.ProjectDto;
import beSoft.tn.SchedulerProject.model.Project;
import beSoft.tn.SchedulerProject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class ProjectController {
    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping("/projects")
    public ProjectDto saveProject(@RequestBody Project project) {
        return projectService.save(project);
    }
    @GetMapping("/projects")
    public List<ProjectDto> getAllProjects() {
        return projectService.findAll();
    }
    @GetMapping("/projects/{id}")
    public ProjectDto getProject(@PathVariable Integer id) {
        return projectService.findById(id);
    }
}
