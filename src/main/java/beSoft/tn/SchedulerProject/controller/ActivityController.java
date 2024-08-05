package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.ActivityDto;
import beSoft.tn.SchedulerProject.model.Activity;
import beSoft.tn.SchedulerProject.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class ActivityController {
    private final ActivityService activityService;
    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }
    @PostMapping("/activities")
    public ActivityDto addActivity(@RequestBody Activity activity) {
        return activityService.save(activity);
    }
    @GetMapping("/activities")
    public List<ActivityDto> getActivities() {
        return activityService.findAll();
    }
    @GetMapping("activities/{id}")
    public ActivityDto getActivity(@PathVariable Integer id) {
        return activityService.findById(id);
    }
}
