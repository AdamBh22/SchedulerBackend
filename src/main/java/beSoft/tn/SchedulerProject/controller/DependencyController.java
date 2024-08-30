package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.DependencyDto;
import beSoft.tn.SchedulerProject.dto.TaskDto;
import beSoft.tn.SchedulerProject.services.DependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependencies")
public class DependencyController {
    @Autowired
    DependencyService dependencyService;
    @CrossOrigin(origins = "http://localhost:4201")
    @PostMapping
    public DependencyDto addDependency(@RequestBody DependencyDto dependency) {
        return dependencyService.save(dependency);
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping
    public List<DependencyDto> getAllDependencies() {
        return dependencyService.findAll();
    }
    @GetMapping("/{id}")
    public DependencyDto getDependency(@PathVariable Integer id) {
        return dependencyService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/relatedTask/{id}")
    public TaskDto getRelatedTask(@PathVariable Integer id) {
        return dependencyService.relatedTask(id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @DeleteMapping("/{id}")
    public void deleteDependency(@PathVariable Integer id) {
        dependencyService.delete(id);
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @PutMapping("/{id}")
    public DependencyDto updateDependency(@PathVariable Integer id, @RequestBody DependencyDto dependency) {
        return dependencyService.update(id, dependency);
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/task/{id}")
    public DependencyDto getDependencyByTaskId(@PathVariable Integer id) {
        return dependencyService.getDependencyByTaskId(id);
    }
}
