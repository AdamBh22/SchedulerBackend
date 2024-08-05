package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.RecentDto;
import beSoft.tn.SchedulerProject.model.Recent;
import beSoft.tn.SchedulerProject.services.RecentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class RecentController {
    private final RecentService recentService;
    @Autowired
    public RecentController(RecentService recentService) {
        this.recentService = recentService;
    }
    @PostMapping("/recents")
    public RecentDto addRecent(@RequestBody Recent recent) {
        return recentService.saveRecent(recent);
    }
    @GetMapping("/recents")
    public List<RecentDto> getAllRecents() {
        return recentService.getAllRecents();
    }
    @GetMapping("/recents/{id}")
    public RecentDto getRecentById(@PathVariable Integer id) {
        return recentService.getRecentById(id);
    }
}
