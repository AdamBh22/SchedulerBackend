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

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping
    public List<AppUserProjectDto> getAllUserProjects() {
        return  appUserProjectService.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/{id}")
    public AppUserProjectDto getUserProject(@PathVariable Integer id) {
        return appUserProjectService.findById(id);
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @PostMapping
    public AppUserProjectDto createUserProject(@RequestBody AppUserProjectDto appUserProjectDto) {
        return appUserProjectService.save(appUserProjectDto);
    }
}
