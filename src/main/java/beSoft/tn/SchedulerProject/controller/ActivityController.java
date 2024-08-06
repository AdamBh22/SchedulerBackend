package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.ActivityDto;
import beSoft.tn.SchedulerProject.model.Activity;
import beSoft.tn.SchedulerProject.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    ActivityService activityService;
    @PostMapping
    public ActivityDto addActivity(@RequestBody ActivityDto activity) {
        return activityService.save(activity);
    }
    @GetMapping
    public List<ActivityDto> getActivities() {
        return activityService.findAll();
    }
    @GetMapping("/{id}")
    public ActivityDto getActivity(@PathVariable Integer id) {
        return activityService.findById(id);
    }
}
