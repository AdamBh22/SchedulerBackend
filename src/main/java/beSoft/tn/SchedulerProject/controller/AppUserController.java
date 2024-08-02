package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.model.AppUser;
import beSoft.tn.SchedulerProject.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class AppUserController {
    private final AppUserRepository appUserRepository;
    @Autowired
    public AppUserController(final AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    @PostMapping("/user")
    public AppUser post(@RequestBody final AppUser appUser) {
        return appUserRepository.save(appUser);
    }
    @GetMapping("/user")
    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

}
