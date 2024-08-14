package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.RecentDto;
import beSoft.tn.SchedulerProject.model.Recent;
import beSoft.tn.SchedulerProject.services.RecentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recents")
public class RecentController {
    @Autowired
    RecentService recentService;
    @PostMapping
    public RecentDto addRecent(@RequestBody RecentDto recent) {
        return recentService.saveRecent(recent);
    }
    @GetMapping
    public List<RecentDto> getAllRecents() {
        return recentService.getAllRecents();
    }
    @GetMapping("/{id}")
    public RecentDto getRecentById(@PathVariable Integer id) {
        return recentService.getRecentById(id);
    }
}
