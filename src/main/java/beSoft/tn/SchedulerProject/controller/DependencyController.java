package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.DependencyDto;
import beSoft.tn.SchedulerProject.services.DependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependencies")
public class DependencyController {
    @Autowired
    DependencyService dependencyService;
    @PostMapping
    public DependencyDto addDependency(@RequestBody DependencyDto dependency) {
        return dependencyService.save(dependency);
    }
    @GetMapping
    public List<DependencyDto> getAllDependencies() {
        return dependencyService.findAll();
    }
    @GetMapping("/{id}")
    public DependencyDto getDependency(@PathVariable Integer id) {
        return dependencyService.findById(id);
    }
}
