package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.AppUserDto;
import beSoft.tn.SchedulerProject.dto.ProjectDto;
import beSoft.tn.SchedulerProject.dto.TaskDto;
import beSoft.tn.SchedulerProject.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @CrossOrigin(origins = "http://localhost:4201")
    @PostMapping( "/add")
    public ResponseEntity<AppUserDto> addAppUser(@RequestBody AppUserDto appUserDto) {
        AppUserDto result=appUserService.save(appUserDto);
        return ResponseEntity.ok(result);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping
    public List<AppUserDto> getAllAppUsers() {
        return appUserService.findAllAppUsers();
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping(value = "/{id}")
    public AppUserDto getAppUser(@PathVariable Integer id) {
        return appUserService.findAppUserById(id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping(value = "/projectsByUser/{id}")
    public List<ProjectDto> getAppUserProjects(@PathVariable Integer id) {
        return appUserService.findAllProjects(id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping(value = "/tasks/{id}")
    public List<TaskDto> getAppUserTasks(@PathVariable Integer id) {
        return appUserService.findAllTasks(id);
    }

    @CrossOrigin(origins = "http://localhost:4201")
    @PutMapping(value = "/{id}")
    public AppUserDto updateAppUser(@PathVariable Integer id, @RequestBody AppUserDto appUserDto) {
        return appUserService.updateAppUser(id, appUserDto);
    }

}
