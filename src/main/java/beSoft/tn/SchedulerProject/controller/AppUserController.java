package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.AppUserDto;
import beSoft.tn.SchedulerProject.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @PostMapping( "/add")
    //@ResponseBody
    public ResponseEntity<AppUserDto> addAppUser(@RequestBody AppUserDto appUserDto) {
        AppUserDto result=appUserService.save(appUserDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public List<AppUserDto> getAllAppUsers() {
        return appUserService.findAllAppUsers();
    }

    @GetMapping(value = "/{id}")
    public AppUserDto getAppUser(@PathVariable Integer id) {
        return appUserService.findAppUserById(id);
    }
}
