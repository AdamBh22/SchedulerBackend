package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.ActivityDto;
import beSoft.tn.SchedulerProject.dto.AppUserDto;
import beSoft.tn.SchedulerProject.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    ActivityService activityService;
    @CrossOrigin(origins = "http://localhost:4201")
    @PostMapping
    public ActivityDto addActivity(@RequestBody ActivityDto activity) {
        return activityService.save(activity);
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping
    public List<ActivityDto> getActivities() {
        return activityService.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/{id}")
    public ActivityDto getActivity(@PathVariable Integer id) {
        return activityService.findById(id);
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/user/{id}")
    public AppUserDto getUser(@PathVariable Integer id) {
        return activityService.findAppUserById(id);
    }
    @CrossOrigin(origins = "http://localhost:4201")
    @GetMapping("/task/{id}")
    public List<ActivityDto> getActivityByTaskId(@PathVariable Integer id) {
        return activityService.getActivitiesByTaskId(id);
    }
}
