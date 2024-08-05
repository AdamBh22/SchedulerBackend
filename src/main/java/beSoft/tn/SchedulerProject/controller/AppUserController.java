package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.AppUserDto;
import beSoft.tn.SchedulerProject.model.AppUser;
import beSoft.tn.SchedulerProject.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
public class AppUserController {
    private final AppUserService appUserService;
    @Autowired
    public AppUserController(final AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @PostMapping("/users")
    public AppUserDto addAppUser(@RequestBody final AppUser appUser) {
        return appUserService.save(appUser);
    }
    @GetMapping("/users")
    public List<AppUserDto> getAllAppUsers() {
        return appUserService.findAllAppUsers();
    }
    @GetMapping("/users/{id}")
    public AppUserDto getAppUser(@PathVariable final Integer id) {
        return appUserService.findAppUserById(id);
    }
}
