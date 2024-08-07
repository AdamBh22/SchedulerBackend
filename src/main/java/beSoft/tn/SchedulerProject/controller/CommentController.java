package beSoft.tn.SchedulerProject.controller;

import beSoft.tn.SchedulerProject.dto.CommentDto;
import beSoft.tn.SchedulerProject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping
    public CommentDto createComment(@RequestBody CommentDto comment) {
        return commentService.save(comment);
    }
    @GetMapping
    public List<CommentDto> getAllComments() {
        return commentService.getAll();
    }
    @GetMapping("/{id}")
    public CommentDto getComment(@PathVariable Integer id) {
        return commentService.getById(id);
    }
}
