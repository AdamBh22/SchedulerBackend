package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.AppUserProjectDto;
import beSoft.tn.SchedulerProject.model.AppUserProject;
import beSoft.tn.SchedulerProject.services.AppUserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/projects")
public class AppUserProjectController {
    @Autowired
    private AppUserProjectService appUserProjectService;

    @GetMapping
    public List<AppUserProjectDto> getAllUserProjects() {
        return  appUserProjectService.findAll();
    }
    @GetMapping("/{id}")
    public AppUserProjectDto getUserProject(@PathVariable Integer id) {
        return appUserProjectService.findById(id);
    }
    @PostMapping
    public AppUserProjectDto createUserProject(@RequestBody AppUserProjectDto appUserProjectDto) {
        return appUserProjectService.save(appUserProjectDto);
    }
}
