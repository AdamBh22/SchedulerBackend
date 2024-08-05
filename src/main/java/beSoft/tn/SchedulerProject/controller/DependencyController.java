package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.DependencyDto;
import beSoft.tn.SchedulerProject.model.Dependency;
import beSoft.tn.SchedulerProject.services.DependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class DependencyController {
    private final DependencyService dependencyService;
    @Autowired
    public DependencyController(DependencyService dependencyService) {
        this.dependencyService = dependencyService;
    }
    @PostMapping("/dependency")
    public DependencyDto addDependency(@RequestBody Dependency dependency) {
        return dependencyService.save(dependency);
    }
    @GetMapping("/dependency")
    public List<DependencyDto> getAllDependencies() {
        return dependencyService.findAll();
    }
    @GetMapping("/dependency/{id}")
    public DependencyDto getDependency(@PathVariable Integer id) {
        return dependencyService.findById(id);
    }
}
